package com.sagar.resume.repository;

import com.sagar.resume.document.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ResumeRepository extends MongoRepository<Resume,String> {
    List<Resume>findByUserIdOrderByUpdatedAtDesc(String userid);
    Optional<Resume> findByUserIdAndId(String userId,String id);

}
