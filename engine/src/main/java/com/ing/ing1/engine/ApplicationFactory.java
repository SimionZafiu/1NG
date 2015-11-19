package com.ing.ing1.engine;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by ggkekas on 19/11/15.
 */
@Component
public class ApplicationFactory {

    private static Configuration configuration;

    @Bean
    public static Configuration getConfiguration() {
        if(configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    private static SingleAccountEngine engine;

    @Bean(initMethod = "start")
    public static SingleAccountEngine createEngine() {
        if(engine == null) {
            engine = new SingleAccountEngine();
        }
        return engine;
    }
}
