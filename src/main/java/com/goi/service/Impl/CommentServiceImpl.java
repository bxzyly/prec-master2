package com.goi.service.Impl;

import com.goi.entity.Comment;
import com.goi.repository.ArticleRepository;
import com.goi.repository.CommentRepository;
import com.goi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    @Transactional
    public String addComment(Comment comment){
        commentRepository.save(comment);
        return "添加成功！";
    }

    @Override
    @Transactional
    public String  findCommentByArticeId(String id){
//        Result< List<List<Comment>>> result = new Result<>();
//        String articleCommentIds = articleRepository.findCommentIdsById(Integer.valueOf(id));//获得文章评论id字符串
//        if("0".equals(articleCommentIds)){
//
//        }else{
//            String[] ids = articleCommentIds.split("\\\\");
//            List<List<Comment>>  lists= new ArrayList<>();
//            for(int i = 1;i<ids.length;i++){
//                List<Comment> list = new ArrayList<>();
//                String commentedIds = commentRepository.findCommentedIdsById(Integer.valueOf(ids[i]));
//                if(!"0".equals(commentedIds)){
//                    String[] ids2 = commentedIds.split("\\\\");
//                    for(int j=1;j< ids2.length;j++){
//                        Comment commnet = commentRepository.findOne(Integer.valueOf(ids2[j]));
//                        list.add(commnet);
//                    }
//                }
//                lists.add(list);
//            }
//            result.setContent(lists);
//        }
        return null;
    }
}
