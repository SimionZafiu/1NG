package com.ing.ing1.engine;

import com.ing.ing1.dto.Account;
import com.ing.ing1.dto.List__;
import com.ing.ing1.dto.ProdFeatures;
import com.ing.ing1.dto.Quote;
import com.ing.ing1.http.AuthRestTemplate;
import com.ing.ing1.http.INGApiClient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Main engine loop for the single account
 *
 * Created by ggkekas on 17/11/15.
 */
@Service
public class SingleAccountEngine {

    private static final Logger LOGGER = LogManager.getLogger(SingleAccountEngine.class);
    private static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(10);
    private static final Random RANDOM = new Random();

    private INGApiClient apiClient = new INGApiClient();

    @Autowired
    private Configuration configuration;

    public void start() {
        EXECUTOR.scheduleAtFixedRate(() -> makeRESTRequest(), 0, 10, TimeUnit.SECONDS);
        LOGGER.info("Started single account engine");
    }

    private void makeRESTRequest() {
        try {
            //   GET example
            RestTemplate restTemplate = new RestTemplate();
            testGetRequest(restTemplate);
        } catch(Throwable e) {
            LOGGER.error("Error", e);
        }
    }

    private void testGetRequest(RestTemplate restTemplate) {
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        LOGGER.info(quote.toString());
//        ServerStatus serverStatus = apiClient.getServerStatus();
//        LOGGER.info("Server Status: " + (serverStatus != null ? serverStatus.toString() : "Server not working"));
        ProdFeatures products = apiClient.getProducts("ACC");
        for(List__ product : products.getList()) {
            LOGGER.info("Id: " + product.getId() + "\tDescription:" + product.getDescription() + "\tType: "
                    + (product.getType() != null ? product.getType().getCode() : "None" )+ "/"
                    + (product.getSubType() != null ? product.getSubType().getCode() : "None"));
        }
        Account account = apiClient.getAccount("IAUSDUIOA23874893");
        LOGGER.info("Account: " + (account != null ? account.toString() : "Not found"));
        LOGGER.info("Debug: " + configuration.isDebug());
    }

    private void makePostRequest() {
        // POST upload with exchange
        String url = "http://127.0.0.1:8080/uploadFile";
        String filename = "/home/ggkekas/Downloads/ideal.tar.gz";
        String location = "/home/ggkekas/test/apache" + RANDOM.nextInt(1000) + ".tar.gz";
        AuthRestTemplate authRestTemplate = new AuthRestTemplate("user", "password");
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("name", location);
        Resource resource = new FileSystemResource(filename);
        map.add("file", resource);
//            String result = authRestTemplate.execute(url, HttpMethod.POST,
//                    (ClientHttpRequest clientHttpRequest) -> {
//                        clientHttpRequest.getHeaders().setContentType(MediaType.APPLICATION_OCTET_STREAM);
//                        IOUtils.copy(resource.getInputStream(), clientHttpRequest.getBody());
//                    },
//                    new HttpMessageConverterExtractor<>(String.class, authRestTemplate.getMessageConverters()), map);
        String result = authRestTemplate.postForObject(url, map, String.class);
        LOGGER.info(result);
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
