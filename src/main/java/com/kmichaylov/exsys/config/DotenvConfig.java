package com.kmichaylov.exsys.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {

    public Dotenv dotenv() {
        return Dotenv.load();
    }
}
