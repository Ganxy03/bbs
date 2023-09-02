package com.ganxy03.bbs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ganxy03.bbs.entity.User;
import com.ganxy03.bbs.repository.UserRepository;
import com.ganxy03.bbs.service.IUserService;
import com.ganxy03.bbs.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
//@CrossOrigin
//@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
//@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

    private final IUserService userService;
    private final RedisUtil redisUtil;

    @Autowired
    public UserController(IUserService userService, RedisUtil redisUtil) {
        this.userService = userService;
        this.redisUtil = redisUtil;
    }

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // 处理注册逻辑
        userService.register(user);
        return "200";
    }

//    @PostMapping("/login")
//    public void login(@RequestBody Map<String, String> request, HttpServletRequest servletRequest, HttpServletResponse response) throws IOException {
//        String nickname = request.get("nickname");
//        String password = request.get("password");
//        // 根据昵称查询用户
//        User user = userService.findByNickname(nickname);
//        // 验证用户存在且密码正确
//        if (user != null && user.getPassword().equals(password)) {
//            // 生成token
//            String token = UUID.randomUUID().toString();
//            // 将token存储到Redis中，设置过期时间为0.5小时
//            redisUtil.set(token, nickname, 1800);
//            // 设置响应状态码为200
//            response.setStatus(HttpServletResponse.SC_OK);
//            // 设置响应头Content-Type为text/plain => application/json
//            response.setHeader("Content-Type", "application/json;charset=UTF-8");
//            // 将token作为响应体返回给前端
//            response.getWriter().print("\"" + token + "\"");
//        } else {
////            return "500";
//            // 设置响应状态码为401
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            // 设置响应头Content-Type为text/plain -> application/json
//            response.setHeader("Content-Type", "application/json;charset=UTF-8");
//            // 返回错误信息给前端
//            response.getWriter().write("用户名或密码错误");
//        }
//    }


//    @PostMapping("/login")
//    public void login(@RequestBody Map<String, String> request, HttpServletRequest servletRequest, HttpServletResponse response) throws IOException {
//        String nickname = request.get("nickname");
//        String password = request.get("password");
//        // 根据昵称查询用户
//        User user = userService.findByNickname(nickname);
//        // 验证用户存在且密码正确
//        if (user != null && user.getPassword().equals(password)) {
//            // 生成token
//            String token = UUID.randomUUID().toString();
//
//            // 创建包含用户名和token的Map对象
//            Map<String, Object> result = new HashMap<>();
//            result.put("nickname", nickname);
//            result.put("token", token);
//
//            // 将Map对象转换为JSON字符串
//            String jsonResult = new ObjectMapper().writeValueAsString(result);
//
//            // 设置响应的Content-Type为application/json
//            response.setContentType("application/json");
//
//            // 将JSON字符串写入响应中
//            response.getWriter().print(jsonResult);
//        } else {
//            // 用户名或密码错误，返回错误信息
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().print("Invalid username or password");
//        }
//    }
    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> request, HttpServletRequest servletRequest, HttpServletResponse response) throws IOException {
        String nickname = request.get("nickname");
        String password = request.get("password");
        // 根据昵称查询用户
        User user = userService.findByNickname(nickname);
        // 验证用户存在且密码正确
        if (user != null && user.getPassword().equals(password)) {
            // 生成token
            String token = UUID.randomUUID().toString();
            // 将token存储到Redis中，设置过期时间为0.5小时
            redisUtil.set(token, nickname, 1800);
            // 设置响应状态码为200
            response.setStatus(HttpServletResponse.SC_OK);
            // 设置响应头Content-Type为text/plain => application/json
            response.setHeader("Content-Type", "application/json;charset=UTF-8");

            // 创建包含用户名和token的Map对象
            Map<String, Object> result = new HashMap<>();
            result.put("nickname", URLEncoder.encode(nickname, "UTF-8")); // 对nickname进行编码
            result.put("token", token);

            // 将Map对象转换为JSON字符串
            String jsonResult = new ObjectMapper().writeValueAsString(result);

            // 设置响应的Content-Type为application/json
            response.setContentType("application/json");

            // 将JSON字符串写入响应中
            response.getWriter().print(jsonResult);
        } else {
            // 用户名或密码错误，返回错误信息
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("Invalid username or password");
        }
    }

//    @PostMapping("/info")
//    public ResponseEntity<User> getUserInfoByToken(@RequestBody String token) {
//        // 从Redis或其他存储中通过token获取用户信息
//        String nickname = redisUtil.get(token);
//        if (nickname == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        // 根据nickname查询用户信息
//        User user = userRepository.findByNickname(nickname);
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.ok(user);
//    }


//    @PostMapping("/info")
//    public ResponseEntity<User> getUserInfoByToken(@RequestHeader("Authorization") String token) {
//        // 从Redis或其他存储中通过token获取用户信息
//        String nickname = redisUtil.get(token);
//        if (nickname == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        // 根据nickname查询用户信息
//        User user = userRepository.findByNickname(nickname);
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        // 保存用户信息到本地
//        // ...
//        return ResponseEntity.ok(user);
//    }

    @PostMapping("/logout")
    public void logout(@RequestBody Map<String, String> request, HttpServletRequest servletRequest, HttpServletResponse response) throws IOException {
        String token = request.get("token");

        // 验证 token 的有效性，例如从 Redis 中获取对应的用户名
        String nickname = redisUtil.get(token);
        if (nickname != null) {
            // 从 Redis 中删除对应的 token
            redisUtil.delete(token);

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print("Logout success");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print("Invalid token");
        }
    }




}
