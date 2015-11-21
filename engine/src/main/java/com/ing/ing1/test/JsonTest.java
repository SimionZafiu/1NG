package com.ing.ing1.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.ing1.dto.Customer;
import com.ing.ing1.dto.Customers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ggkekas on 21/11/15.
 */
public class JsonTest {
    private String json = "";

    private void parseJson() {
        ObjectMapper om = new ObjectMapper();
        try {
            Customers customers = om.readValue(new File("/home/ggkekas/workspace/hackathlon/1NG/engine/src/main/resources/customers.json"), Customers.class);
            System.out.println(customers.getCustomers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String... args) {
//        new JsonTest().parseJson();
//        List<String> some = null;
//        System.out.println(some.stream().filter(s -> s != null).collect(Collectors.toList()));
//    }
}
