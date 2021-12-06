package com.tech1io.service;

import com.tech1io.dao.UsersRepository;
import com.tech1io.entity.ColorEnum;
import com.tech1io.entity.Users;
import com.tech1io.request.UserSaveRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static int LIMIT = 3;
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

    public List<String> getName(int count) {
        //крутимся пока не иссякнут записи (пачка не станет меньше лимита)
        boolean continueFlag = true;
        int page = 0;
        List<String> userName = new ArrayList<>();
        while (continueFlag) {
            Page<Users> users = repository.findAll(PageRequest.of(page, LIMIT));
            if (users.getContent().size() < LIMIT) {
                continueFlag = false;
            }
            users.forEach(one -> {
                if (one.getArticle().size() >= count) {
                    userName.add(one.getName());
                }
            });
            page++;
        }
        return userName;
    }
}
