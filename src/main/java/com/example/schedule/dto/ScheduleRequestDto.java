package com.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class ScheduleRequestDto {
    private Long id; //식별자
    private int day; //날짜
    private int pw; //비밀번호
    private String name;
    private String content;
    private String title;
    /*
    json -> 요청
    {
        pw : 123
        title : "부트캠프",
        content : "스프링부트",
        name : "개발자",
    }
     */
}
