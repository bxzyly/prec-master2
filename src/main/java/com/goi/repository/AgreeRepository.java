package com.goi.repository;

import com.goi.entity.Agree;
import org.springframework.data.repository.CrudRepository;

public interface AgreeRepository extends CrudRepository<Agree,Long>{

    Agree findByUserIdAndArticleId(Long userId,Long articleId);
}
