package com.foo.dao;

import com.foo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addPerson(User user) {
       jdbcTemplate.update("INSERT INTO user (person_id, full_name) VALUES (?, ?)",
                user.getId(), user.getName());
        System.out.println("Person Added!!");
    }
}