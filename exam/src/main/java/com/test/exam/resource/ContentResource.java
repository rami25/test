package com.test.exam.resource;


import com.test.exam.model.Content;
import com.test.exam.service.ContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentResource {
    private final ContentService contentService;

    public ContentResource(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Content>> getAllContent () {
        List<Content> contents = contentService.findAllContents();
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Content> getContentById (@PathVariable("id") Long id) {
        Content content = contentService.findContentById(id);
        System.out.println();
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Content> addcontent(@RequestBody Content content) {
        Content newContent = contentService.addContent(content);
        return new ResponseEntity<>(newContent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Content> updateContent(@RequestBody Content content) {
        Content updateContent = contentService.updateContent(content);
        return new ResponseEntity<>(updateContent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContent(@PathVariable("id") Long id) {
        contentService.deleteContent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
