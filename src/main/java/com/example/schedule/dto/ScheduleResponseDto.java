package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private long id; //식별자
    private int day; //날짜
    private String title; //제목
    private String contents; //내용
    private String name; //작성자명
    private int pw; //비밀번호
    private List<CommetResponseDto> comments;

    /*
    { json -> 응답
       요청한 값대한
       속성들의 결과값
    }
     */

    public ScheduleResponseDto(Schedule schedule, List<CommetResponseDto> comments) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.pw = schedule.getPw();
        this.day = schedule.getDay();
        this.name = schedule.getName();
        this.comments = comments;
    }

}
