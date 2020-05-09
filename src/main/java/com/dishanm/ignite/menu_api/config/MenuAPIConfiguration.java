package com.dishanm.ignite.menu_api.config;

import dishanm.ignite.config.IgniteConfigurationManager;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuAPIConfiguration {

    @Bean(name = "igniteConfiguration")
    public IgniteConfiguration igniteConfiguration() {
        return IgniteConfigurationManager.getConfiguration();
    }


    @Bean(destroyMethod = "close")
    Ignite ignite(IgniteConfiguration igniteConfiguration) throws IgniteException {
        final Ignite ignite = Ignition.start(igniteConfiguration);
        ignite.cluster().active(true);
        return ignite;
    }
}
