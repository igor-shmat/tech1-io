package com.tech1io.init;

import com.tech1io.dao.ArticleRepository;
import com.tech1io.dao.UsersRepository;
import com.tech1io.entity.Article;
import com.tech1io.entity.ColorEnum;
import com.tech1io.entity.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Order(1)
@Component
public class UserArticleInit implements CommandLineRunner {

    private final UsersRepository repository;
    private final ArticleRepository articleRepository;

    public UserArticleInit(UsersRepository repository, ArticleRepository articleRepository) {
        this.repository = repository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() < 1){

            Users users1 = new Users("users1",12, Arrays.asList(new Article("text1", ColorEnum.BLUE),new Article("text4", ColorEnum.WHITE)));
            Users users2 = new Users("users2",16, Arrays.asList(new Article("text3", ColorEnum.GREEN),new Article("text4", ColorEnum.WHITE)));
            Users users3 =  new Users("users3",22, Arrays.asList(new Article("text3", ColorEnum.GREEN),new Article("text4", ColorEnum.WHITE)));
            Users users4 =  new Users("users4",32, Arrays.asList(new Article("text3", ColorEnum.GREEN),new Article("text4", ColorEnum.WHITE)));
            Users users5 =  new Users("users5",36, Arrays.asList(new Article("text3", ColorEnum.GREEN),new Article("text4", ColorEnum.WHITE)));
            Users users6 =  new Users("users6",27, Arrays.asList(new Article("text3", ColorEnum.GREEN),new Article("text4", ColorEnum.WHITE)));
            Users users7 =  new Users("users7",18, Arrays.asList(new Article("text3", ColorEnum.GREEN),new Article("text4", ColorEnum.WHITE),new Article("text5", ColorEnum.RED)));

            repository.saveAll(Arrays.asList(users1, users2, users3, users4,users5, users6, users7));

        }
    }
}
