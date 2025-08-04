package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@Entity
@NoArgsConstructor
public class Schedule {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY) //PK
     private Long id; //식별자
     private int day; //날짜
     private String title; //제목
     private String contents; //내용
     private String name; //작성자명
     private int pw; //비밀번호
     public Schedule(String name, String title, String content) {
             this.name = name;
             this.title = title;
             this.contents = content;
     }

     @OneToMany(mappedBy = "scedule", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Comment> comments;

}
