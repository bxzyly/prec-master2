package com.goi.repository;

import com.goi.entity.Agree;
import com.goi.entity.Disagree;
import org.springframework.data.repository.CrudRepository;

public interface DisagreeRepository extends CrudRepository<Disagree,Long>{

    Disagree findByUserIdAndArticleId(Long userId, Long articleId);
}
