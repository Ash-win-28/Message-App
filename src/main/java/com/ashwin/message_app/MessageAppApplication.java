package com.ashwin.message_app;

import com.ashwin.message_app.configuration.DataStaxAstraProperties;
import com.ashwin.message_app.data.Folders;
import com.ashwin.message_app.repository.FoldersRepository;
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
public class MessageAppApplication {

	@Autowired
	FoldersRepository foldersRepository;

	public static void main(String[] args) {
		SpringApplication.run(MessageAppApplication.class, args);
	}

	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}


	@PostConstruct
	public void init() {
		foldersRepository.save(new Folders("Ashwin", "Inbox", "blue"));
		foldersRepository.save(new Folders("Ashwin", "Sent", "green"));
		foldersRepository.save(new Folders("Ashwin", "Important", "red"));
	}
}
