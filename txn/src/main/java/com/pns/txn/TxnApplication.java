package com.pns.txn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class TxnApplication {

	public static void main(String[] args) {
		SpringApplication.run(TxnApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
//		return args -> {
//			kafkaTemplate.send("ftrnotif", "henlo ftr notif");
//		};
//	}

}
