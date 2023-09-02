package com.ganxy03.bbs.service;


import com.ganxy03.bbs.entity.User;
import com.ganxy03.bbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
public class IUserService {
//    public void register(User user) {
//        // 验证用户输入的数据
////        if (user.getNickname() == null || user.getNickname().isEmpty()) {
////            throw new IllegalArgumentException("用户名不能为空");
////        }
////        if (user.getPassword() == null || user.getPassword().isEmpty()) {
////            throw new IllegalArgumentException("密码不能为空");
////        }
//
//        // 保存用户信息到数据库，这里使用伪代码表示
//        // userRepository.save(user);
//
//        // 注册成功
//        System.out.println("注册成功");
//    }
@Autowired
private UserRepository userRepository;
    public void register(User user) {
//        // 验证用户输入的数据
//        if (user.getNickname() == null || user.getNickname().isEmpty()) {
//            throw new IllegalArgumentException("用户名不能为空");
//        }
//        if (user.getPassword() == null || user.getPassword().isEmpty()) {
//            throw new IllegalArgumentException("密码不能为空");
//        }
        // 保存用户信息到数据库
        userRepository.save(user);
        // 注册成功
        System.out.println("注册成功");
    }

    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

}
