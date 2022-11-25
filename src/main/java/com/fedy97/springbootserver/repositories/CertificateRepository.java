package com.fedy97.springbootserver.repositories;

import com.fedy97.springbootserver.models.Certificate;
import com.fedy97.springbootserver.models.Education;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends MongoRepository<Certificate, String> {
    // @Query("{'author' : { $in : ?0}, 'pageNumber' : { $gt : ?1, $lt : ?2},'publishedYear' : {$nin : ?3}}")
    public long count();

}
