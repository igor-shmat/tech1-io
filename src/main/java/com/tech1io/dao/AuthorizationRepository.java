package com.tech1io.dao;

import com.tech1io.entity.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorization,Long> {


    Authorization findByLogin(String login);
}
