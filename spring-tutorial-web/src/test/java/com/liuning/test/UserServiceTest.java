package com.liuning.test;

import com.liuning.service.account.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-service.xml")
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void openAccount() {
        String result = userService.openAccount();
        System.out.println(result);
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-service.xml");
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.openAccount());
    }
}
