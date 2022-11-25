package com.fedy97.springbootserver.repositories;

import com.fedy97.springbootserver.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    // @Query("{'author' : { $in : ?0}, 'pageNumber' : { $gt : ?1, $lt : ?2},'publishedYear' : {$nin : ?3}}")
    public long count();

}
