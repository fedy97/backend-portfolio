package com.fedy97.springbootserver.repositories;

import com.fedy97.springbootserver.models.Personal;
import com.fedy97.springbootserver.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends MongoRepository<Personal, String> {
    // @Query("{'author' : { $in : ?0}, 'pageNumber' : { $gt : ?1, $lt : ?2},'publishedYear' : {$nin : ?3}}")
    public long count();

}
