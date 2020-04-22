package com.formation.seletuto.serenitybdd.properties;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rdu-acceptance-tests")
@Getter
@Setter
public class RduProperties {

    @NotNull
    private String iamUrl;

    @NotNull
    private String appLink;

    @NotNull
    private String username;

    @NotNull
    private String password;

}
