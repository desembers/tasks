package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

     private String content;
     private String author;
     private int password;

     @CreatedDate
     private LocalDateTime createdAt;

     @LastModifiedDate
     private LocalDateTime updatedAt;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "schedule_id")
     private Schedule schedule;

    public Comment(String content, String author, int password, Schedule schedule) {
        this.content = content;
        this.author = author;
        this.password = password;
        this.schedule = schedule;
    }

}
