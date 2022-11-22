package com.fedy97.springbootserver.repositories;

import com.fedy97.springbootserver.models.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends MongoRepository<Experience, String> {
    // @Query("{'author' : { $in : ?0}, 'pageNumber' : { $gt : ?1, $lt : ?2},'publishedYear' : {$nin : ?3}}")
    public long count();

}
