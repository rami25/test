package com.test.exam.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Content implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String fileUrl;
    public Content() {}
    public Content(Long id, String name, String fileUrl){
        this.id = id;
        this.name = name;
        this.fileUrl = fileUrl;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getFileUrl(){
        return this.fileUrl;
    }
    public void setFileUrl(String fileUrl){
        this.fileUrl = fileUrl;
    }
    @Override
    public String toString(){
        return "Content{" +
                "id : " + id + " , " +
                "name : '" + name + "' , " +
                "fileUrl : '" + fileUrl + "'" +
                "}";
    }

}
