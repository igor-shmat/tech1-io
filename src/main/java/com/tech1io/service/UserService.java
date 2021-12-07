package com.tech1io.service;

import com.tech1io.dao.UsersRepository;
import com.tech1io.entity.ColorEnum;
import com.tech1io.entity.Users;
import com.tech1io.request.UserSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository repository;

    public UserService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<Users> getByAgeAfter(int age) {
        return repository.findByAgeAfter(age);
    }

    public List<Users> getAllByColor(ColorEnum color) {
        return repository.getAllByColor(color);
    }

    public void save(UserSaveRequest request) {
        repository.save(new Users(request.getName(), request.getAge(), request.getArticles()));
    }

    public List<String> getUserName(int count) {
        return repository.getUserName(count);
    }
}
