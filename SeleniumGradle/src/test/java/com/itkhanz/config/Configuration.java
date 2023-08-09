package com.itkhanz.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface Configuration extends Config {
    @Config.Key("baseUrl")
    String url();

    @Config.Key("env")
    String environment();

    @Key("faker.locale")
    String faker();

}
