package com.example.schedule.controller;

import com.example.schedule.Input.CommentService;
import com.example.schedule.Input.ScheduleService;
import com.example.schedule.dto.CommentRequestDto;
import com.example.schedule.dto.CommetResponseDto;
import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/days")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private CommentService commentService;

    //생성자 주입 SchduleService
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping //일정 생성 Create
    public ResponseEntity<String> save(@RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.save(requestDto) ,HttpStatus.CREATED);
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<CommetResponseDto> addComment(@PathVariable Long id,
                                                        @RequestBody CommentRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commentService.createComment(id, dto));
    }

   @GetMapping //전체 일정 조회 Read
   public List<ScheduleResponseDto> findAll() {
        return scheduleService.findAll();
   }


   @GetMapping("/{id}") //일정 id 조회 (하나)
   public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findById(id),HttpStatus.OK);
   }

    @GetMapping("/{id}/with")
    public ResponseEntity<ScheduleResponseDto> findScheduleWithComments(@PathVariable Long id) {
        List<CommetResponseDto> comments = commentService.getCommentsByScheduleId(id);
        Schedule schedule = scheduleService.findEntityById(id);
        ScheduleResponseDto dto = new ScheduleResponseDto(schedule, comments);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}") //일정 수정하기
   public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id,
                                                     @RequestBody ScheduleRequestDto requestdto) {
        return new ResponseEntity<>(scheduleService.update(id, requestdto), HttpStatus.OK);
   }

   @DeleteMapping("/{id}") // 일정 삭제
   public ResponseEntity<Void> delete(@PathVariable Long id) {
       scheduleService.delete(id);
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

}
