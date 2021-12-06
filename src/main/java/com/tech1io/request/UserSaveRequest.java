package com.tech1io.request;

import com.tech1io.entity.Article;
import lombok.Data;

import java.util.List;

@Data
public class UserSaveRequest {
    private String name;
    private int age;
    private List<Article> articles;
}
