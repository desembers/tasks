package com.example.schedule.dto;

import com.example.schedule.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommetResponseDto {
     private long id;
     private String conetent;
     private String author;
     private LocalDateTime createdAt;
     //private LocalDateTime modifiedAt;

     public CommetResponseDto(Comment comment) {
         this.id = comment.getId();
         this.conetent = comment.getContent();
         this.author = comment.getAuthor();
         this.createdAt = comment.getCreatedAt();
         //this.modifiedAt = comment.getModifiedAt();
     }

}
