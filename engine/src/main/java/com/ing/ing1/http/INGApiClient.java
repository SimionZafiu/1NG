package com.ing.ing1.http;

import com.ing.ing1.dto.Account;
import com.ing.ing1.dto.ProdFeatures;
import com.ing.ing1.dto.ServerStatus;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ggkekas on 18/11/15.
 */
@EnableAspectJAutoProxy
@Component
public class INGApiClient {
    private static final String URL = "http://213.157.170.77/NL/commonapi/";
    private static final String SERVER_STATUS = "server/status/";
    private static final String ACCOUNTS = "accounts/";
    private static final String PROD_FEATURES = "prod_features/";

    private final RestTemplate restTemplate = new RestTemplate();

    public ServerStatus getServerStatus() {
        return restTemplate.getForObject(URL + SERVER_STATUS, ServerStatus.class);
    }

    public ProdFeatures getProducts(String prod) {
        return restTemplate.getForObject(URL + PROD_FEATURES + (prod != null ? "?type=" + prod : ""), ProdFeatures.class);
    }

    public Account getAccount(String id) {
        return restTemplate.getForObject(URL + ACCOUNTS + id, Account.class);
    }

}
