package com.cb;

import com.cb.model.Session;
import com.cb.repository.SessionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableReactiveCouchbaseRepositories
public class BootLuncher {


    public static void main(String[] args) {
        SpringApplication.run(BootLuncher.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(SessionRepository repository, SessionRepository sessionRepository) {
        return e -> repository.saveAll(getCustList(sessionRepository)).subscribe();
    }

    private List<Session> getCustList(SessionRepository userRepository) {
        List<Session> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Session(UUID.randomUUID().toString()));
        }
        return list;
    }
}
