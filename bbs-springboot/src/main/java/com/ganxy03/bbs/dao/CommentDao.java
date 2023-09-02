package com.ganxy03.bbs.dao;

import com.ganxy03.bbs.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByForeignId(Integer foreignId);

}