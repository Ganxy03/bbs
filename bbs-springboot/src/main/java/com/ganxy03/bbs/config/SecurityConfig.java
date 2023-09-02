//package com.ganxy03.bbs.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/verifyToken").authenticated()
////                .anyRequest().permitAll()
////                .and()
////                .httpBasic();
//        http
//                .authorizeRequests()
////                .antMatchers("/register").permitAll() // 允许注册接口无需认证
//                    .anyRequest().authenticated() // 其他接口需要认证
//                    .and()
//                .formLogin()
//                    .and()
//                .httpBasic()
//                    .and()
//                .logout()
//                    .logoutUrl("/logout") // 自定义退出登录URL
//                    .logoutSuccessUrl("/login") // 退出登录成功后跳转的页面
//                    .invalidateHttpSession(true) // 清除用户会话
//                    .deleteCookies("JSESSIONID"); // 删除相关的cookie
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
////                .withUser("admin").password("{noop}password").roles("USER");
//                .withUser("admin").password("{noop}123456").roles("USER");
//    }
//
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//}
