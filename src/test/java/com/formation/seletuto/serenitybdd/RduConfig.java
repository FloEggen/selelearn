package com.formation.seletuto.serenitybdd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:properties/rdu/rdu.properties","classpath:properties/rdu/rdu-${spring.profiles.active}.properties"})
public class RduConfig {
}
