package com.ganxy03.bbs.repository;

import com.ganxy03.bbs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 可以添加自定义的查询方法
    User findByNickname(String nickname);
}
