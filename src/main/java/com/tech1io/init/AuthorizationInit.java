package com.tech1io.init;

import com.tech1io.dao.AuthorizationRepository;
import com.tech1io.entity.Authorization;
import com.tech1io.entity.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class AuthorizationInit implements CommandLineRunner {

    private final AuthorizationRepository repository;

    public AuthorizationInit(AuthorizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = repository.count();
        if(count<1){
            repository.save(new Authorization("admin","admin", Role.ADMIN));
        }
    }
}
