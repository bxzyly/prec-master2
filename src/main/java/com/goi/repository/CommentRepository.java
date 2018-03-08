package com.goi.repository;

import com.goi.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment,Long> {

    @Query("select commentedIds from Comment where id = ?1")
    String findCommentedIdsById(int id);
}
