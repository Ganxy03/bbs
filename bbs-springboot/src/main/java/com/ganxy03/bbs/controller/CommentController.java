package com.ganxy03.bbs.controller;
//
//import com.ganxy03.bbs.entity.Comment;
//import com.ganxy03.bbs.service.ICommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/comments")
//public class CommentController {
//
//    @Autowired
//    private ICommentService commentService;
//
//    @PostMapping
//    public Comment createComment(@RequestBody Comment comment) {
//        return commentService.createComment(comment);
//    }
//
//    @GetMapping
//    public List<Comment> getAllComments() {
//        return commentService.getAllComments();
//    }
//
//    // 其他接口方法...
//}

import com.ganxy03.bbs.dao.CommentDao;
import com.ganxy03.bbs.entity.Comment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentDao commentDao;

    @PostMapping
    public void save(@RequestBody Comment comment) {
        comment.setCreate_time(LocalDateTime.now());
        commentDao.save(comment);
    }

    @GetMapping
    public Map<String, Object> list(@RequestParam Integer foreignId) {
        Map<String, Object> map = new HashMap<>();

        List<Comment> comments = commentDao.findAllByForeignId(foreignId);

        List<Comment> rootComments = comments.stream().filter(comment -> comment.getPid() == null).collect(Collectors.toList());

        for (Comment rootComment : rootComments) {
            rootComment.setChildren(comments.stream().filter(comment -> rootComment.getId().equals(comment.getPid())).collect(Collectors.toList()));
            if (rootComment.getPid() != null) {
                rootComment.setChildren(comments.stream()
                        .filter(comment -> rootComment.getId().equals(comment.getPid()))
                        .collect(Collectors.toList()));
            }
        }
        map.put("comments", rootComments);

        return map;
    }
}
