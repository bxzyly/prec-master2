package com.goi.controller;

import com.goi.entity.Comment;
import com.goi.result.Result;
import com.goi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    public String addComment(Comment comment){
        return commentService.addComment(comment);
    }

    /**
     * 通过文章id找全部评论
     * @param articeId
     * @return
     */
    @RequestMapping("/findCommentByArticeId")
    public Result< List<List<Comment>>> findCommentByArticeId(@RequestParam("articeId") String articeId){
        return commentService.findCommentByArticeId(articeId);
    }

}
