package com.goi.service;

import com.goi.entity.Comment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface CommentService {
    @Transactional
    String addComment(Comment comment);

    @Transactional
    String  findCommentByArticeId(String id);
}
