package com.tech1io.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Authorization(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
