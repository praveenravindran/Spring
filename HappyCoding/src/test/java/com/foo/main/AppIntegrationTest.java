package com.foo.main;

import com.foo.config.AopConfig;
import com.foo.config.DatabaseConfig;
import com.foo.dao.PersonDao;
import com.foo.model.User;
import com.foo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;

@RunWith(SpringRunner.class)
public class AppIntegrationTest {

    @MockBean
    PersonDao mockPersonDao;

    @Test
    public void main_mustLogsFromAOP(){
        User user = new User();
        user.setName("Praveen Ravindran");
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class , DatabaseConfig.class);
        UserService userServiceImpl = applicationContext.getBean(UserService.class);

        doNothing().when(mockPersonDao).addPerson(any(User.class));
        userServiceImpl.setPersonDao(mockPersonDao);
        userServiceImpl.testMethod(user);
    }
}