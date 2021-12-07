package com.tech1io;

import com.tech1io.dao.UsersRepository;
import com.tech1io.entity.Article;
import com.tech1io.entity.ColorEnum;
import com.tech1io.entity.Users;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class Tech1IoApplicationTests {
    @Mock
    private UsersRepository usersRepositoryMock;

    @Test
    void getUserNAmeMock() {
        List<String> userName = new ArrayList<>();
        userName.add("Igor");
        Users user = new Users("Igor",21, Arrays.asList(new Article("text", ColorEnum.BLUE),new Article("text2", ColorEnum.RED)));
//        Users user2 = new Users("Igor2",21, Arrays.asList(new Article("text", ColorEnum.BLUE),new Article("text2", ColorEnum.RED),new Article("text3", ColorEnum.WHITE)));

        Mockito.when(usersRepositoryMock.getUserName(2)).thenReturn(userName);
        Assert.isTrue(userName.contains(user.getName()),"userName may by contains name");
    }
}
