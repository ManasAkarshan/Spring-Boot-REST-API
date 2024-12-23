package com.manas.SpringBootRestAPI.configuration;

import com.manas.SpringBootRestAPI.DB;
import com.manas.SpringBootRestAPI.DevDB;
import com.manas.SpringBootRestAPI.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
//    @Qualifier("primary")
    @ConditionalOnProperty(name = "project.name", havingValue="development")
    public DB getDevDBBean(){
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDB(){
        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
