package com.ing.ing1.engine;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by ggkekas on 19/11/15.
 */
@Component
@ConfigurationProperties(prefix="singleaccount")
public class Configuration {
    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    private boolean debug;

}
