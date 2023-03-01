package com.test.exam.service;

import com.test.exam.exception.ContentNotFoundException;
import com.test.exam.model.Content;
import com.test.exam.repo.ContentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ContentService {
    private final ContentRepo contentRepo;

    @Autowired
    public ContentService(ContentRepo contentRepo) {
        this.contentRepo = contentRepo;
    }


    public Content addContent(Content content) {
        return contentRepo.save(content);
    }
    public List<Content> findAllContents() {
        return contentRepo.findAll();
    }

    public Content updateContent(Content content) {
        return contentRepo.save(content);
    }

    public Content findContentById(Long id) {
        return contentRepo.findContentById(id)
                .orElseThrow(() -> new ContentNotFoundException("Content by id " + id + " was not found"));
    }

    public void deleteContent(Long id){
        contentRepo.deleteContentById(id);
    }
}
