package com.message.inboxapp;

import com.message.inboxapp.configuration.DataStaxAstraProperties;
import com.message.inboxapp.folders.model.Folder;
import com.message.inboxapp.folders.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.nio.file.Path;

@SpringBootApplication
@RestController
public class InboxAppApplication {

    @Autowired
    private FolderRepository folderRepository;

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
        System.out.println(astraProperties.getSecureConnectBundle().toPath());
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }

    @PostConstruct
    public void init(){
        folderRepository.save(new Folder("ravindar86","Inbox","blue"));
        folderRepository.save(new Folder("ravindar86","Sent","green"));
        folderRepository.save(new Folder("ravindar86","Trash","orange"));
    }
}
