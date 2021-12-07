package com.tech1io.dao;

import com.tech1io.entity.ColorEnum;
import com.tech1io.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("select count (id) from Users ")
    long count();

    List<Users> findByAgeAfter(int age);

    @Query("select u from Users u inner join u.article c where c.color = :colorEnum")
    List<Users> getAllByColor(ColorEnum colorEnum);

    @Query("SELECT s.name FROM Users s where s.article.size = :count")
    List<String> getUserName(int count);
}
