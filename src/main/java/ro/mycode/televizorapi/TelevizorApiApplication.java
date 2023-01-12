package ro.mycode.televizorapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.televizorapi.model.Televizor;
import ro.mycode.televizorapi.repository.TelevizorRepo;

@SpringBootApplication
public class TelevizorApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(TelevizorApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TelevizorRepo televizorRepo){
		return  args->{

		};
	}



}


