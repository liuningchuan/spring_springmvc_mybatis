package com.liuning.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author liuning
 * @since 2021-07-15 23:52
 */
@Service
public class MemberService {

    @Cacheable(value = "name")
    public String getUserName() {

        System.out.println("获取用户姓名");
        return "TOM";
    }
}
