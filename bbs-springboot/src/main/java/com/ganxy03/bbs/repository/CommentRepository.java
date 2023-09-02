package com.ganxy03.bbs.repository;

import com.ganxy03.bbs.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // 可以根据需要添加其他自定义的查询方法
}
