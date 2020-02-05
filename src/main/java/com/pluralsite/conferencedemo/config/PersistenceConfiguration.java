package com.pluralsite.conferencedemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource(){

        Map<String, String> EnvMap = System.getenv();

        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(EnvMap.get("DB_URL"));
        builder.password(EnvMap.get("DB_PW"));
        builder.username(EnvMap.get("DB_UN"));
        System.out.println("Custom bean init / set");
        return builder.build();
    }

}
