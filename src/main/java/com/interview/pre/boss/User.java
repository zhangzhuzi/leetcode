package com.interview.pre.boss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: ZhangShiZhu
 * @Description:
 * @Date: create in 2021/8/15 10:59
 */
public class User {
    private Integer age;

    public User(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public static void remove(List<User> userList) {
        Iterator<User> userIterator = userList.iterator();
        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getAge() > 20) {
                userIterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(10));
        list.add(new User(20));
        list.add(new User(30));
        list.add(new User(50));
        list.add(new User(51));
        list.add(new User(60));

        remove(list);
        System.out.println();
    }
}
