package com.formation.seletuto.serenity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:properties/serenity/app.properties","classpath:properties/app-${spring.profiles.active}.properties"})
public class AppConfig {
}
