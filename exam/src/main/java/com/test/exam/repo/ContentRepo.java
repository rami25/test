package com.test.exam.repo;

import com.test.exam.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContentRepo extends JpaRepository<Content, Long> {
    void deleteContentById(Long id);
    Optional<Content> findContentById(Long id);
}
