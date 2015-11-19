package com.ing.ing1.service.impl;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ggkekas on 10/09/15.
 */
@RestController
public class SimpleController {

    private static final Logger LOGGER = LogManager.getLogger(SimpleController.class);

    @RequestMapping(value="/test1")
    public String test(
            @RequestParam(value = "name", defaultValue = "Four Seasons") String name) {
        return "Oh yeah bullshit " + name;
    }

    @RequestMapping(value="/test2", method= RequestMethod.POST)
    public String testPost(
            @RequestParam(value = "name", defaultValue = "Four Seasons") String name) {
        return "Oh yeah bullshit " + name;
    }
}
