package com.ing.ing1.http;

/**
 * Created by ggkekas on 17/11/15.
 */

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Convenient subclass of {@link RestTemplate} that is suitable for integration tests.
 * They are fault tolerant, and optionally can carry Basic authentication headers. If
 * Apache Http Client 4.3.2 or better is available (recommended) it will be used as the
 * client, and by default configured to ignore cookies and redirects.
 *
 * @author Georgios Gkekas
 */
public class AuthRestTemplate extends RestTemplate {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    /**
     * Create a new {@link AuthRestTemplate} instance with the specified credentials.
     * @param username the username to use (or {@code null})
     * @param password the password (or {@code null})
     * @param httpClientOptions client options to use if the Apache HTTP Client is used
     */
    public AuthRestTemplate(String username, String password, HttpClientOption... httpClientOptions) {
//        if (ClassUtils.isPresent("org.apache.http.client.config.RequestConfig", null)) {
//            setRequestFactory(
//                    new CustomHttpComponentsClientHttpRequestFactory(httpClientOptions));
//        }
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setOutputStreaming(true);
        requestFactory.setBufferRequestBody(false);

        setRequestFactory(requestFactory);
        addAuthentication(username, password);
        setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
            }
        });
    }

    private void addAuthentication(String username, String password) {
        if (username == null) {
            return;
        }

        List<ClientHttpRequestInterceptor> interceptors = Collections.singletonList(new BasicAuthorizationInterceptor(username, password));
        setRequestFactory(new InterceptingClientHttpRequestFactory(getRequestFactory(),
                interceptors));
    }

    /**
     * Options used to customize the Apache Http Client if it is used.
     */
    public enum HttpClientOption {

        /**
         * Enable cookies.
         */
        ENABLE_COOKIES,

        /**
         * Enable redirects.
         */
        ENABLE_REDIRECTS

    }

    private static class BasicAuthorizationInterceptor implements ClientHttpRequestInterceptor {

        private final String username;

        private final String password;

        BasicAuthorizationInterceptor(String username, String password) {
            this.username = username;
            this.password = (password == null ? "" : password);
        }

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            String token = Base64Utils.encodeToString(
                    (this.username + ":" + this.password).getBytes(UTF_8));
            request.getHeaders().add("Authorization", "Basic " + token);
            return execution.execute(request, body);
        }

    }

    /**
     * {@link HttpComponentsClientHttpRequestFactory} to apply customizations.
     */
    @SuppressWarnings("unused")
    protected static class CustomHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

        private final String cookieSpec;

        private final boolean enableRedirects;

        public CustomHttpComponentsClientHttpRequestFactory(HttpClientOption[] httpClientOptions) {
            Set<HttpClientOption> options = new HashSet<>(Arrays.asList(httpClientOptions));
            this.cookieSpec = (options.contains(HttpClientOption.ENABLE_COOKIES) ? CookieSpecs.STANDARD : CookieSpecs.IGNORE_COOKIES);
            this.enableRedirects = options.contains(HttpClientOption.ENABLE_REDIRECTS);
            this.setBufferRequestBody(false);
        }

        @Override
        protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri) {
            HttpClientContext context = HttpClientContext.create();
            context.setRequestConfig(getRequestConfig());
            return context;
        }

        protected RequestConfig getRequestConfig() {
            Builder builder = RequestConfig.custom().setCookieSpec(this.cookieSpec)
                    .setAuthenticationEnabled(false)
                    .setRedirectsEnabled(this.enableRedirects);
            return builder.build();
        }

    }

}