package com.foo.service;

import com.foo.dao.PersonDao;
import com.foo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private PersonDao personDao;

    @Test
    public void testMethod_mustCallAddPerson(){
        User user = new User();
        user.setName("test");
        UserService userService = new UserService(personDao);
        userService.testMethod(user);
        verify(personDao).addPerson(user);
    }
}