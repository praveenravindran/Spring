package com.foo.service;

import com.foo.aop.TestChecker;
import com.foo.dao.PersonDao;
import com.foo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private PersonDao personDao;

    @Autowired
    public UserService(PersonDao personDao){
        this.personDao = personDao;
    }

    @TestChecker
    public void testMethod(User user) {
        System.out.println("User is Logged");
        personDao.addPerson(user);
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
