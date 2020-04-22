package com.formation.seletuto.serenity.properties;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app-acceptance-tests")
@Getter
@Setter
public class AppProperties {

    @NotNull
    private String env;

    @NotNull
    private String appUrl;

}
