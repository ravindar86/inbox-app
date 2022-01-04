package com.message.inboxapp;

import com.message.inboxapp.configuration.DataStaxAstraProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@SpringBootApplication
@RestController
public class InboxAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(InboxAppApplication.class, args);
    }

    /*@GetMapping("/user")
    public String user(@AuthenticationPrincipal OAuth2User principal){
        System.out.println(principal);
        return principal.getAttribute("name");
    }*/

    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }
}
