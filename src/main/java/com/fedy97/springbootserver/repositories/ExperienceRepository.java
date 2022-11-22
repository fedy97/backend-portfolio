package com.fedy97.springbootserver.repositories;

import com.fedy97.springbootserver.models.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends MongoRepository<Experience, String> {

    public long count();

}
