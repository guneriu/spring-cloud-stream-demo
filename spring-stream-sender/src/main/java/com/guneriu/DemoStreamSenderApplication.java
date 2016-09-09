package com.guneriu;

import com.guneriu.component.TaskMessage;
import com.guneriu.publisher.MessagePublisherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoStreamSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStreamSenderApplication.class, args);
	}


	@Autowired
    private MessagePublisherService messagePublisherService;

	@Bean
    CommandLineRunner sendMessage() {
        return args -> {
            for (int i = 0; i < 1000; i++) {
                messagePublisherService.sendMessage(new TaskMessage(String.valueOf(i)));
                Thread.sleep(1000L);
            }
        };
    }
}
