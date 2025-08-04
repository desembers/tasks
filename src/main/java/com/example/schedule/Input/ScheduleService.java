package com.example.schedule.Input;

import com.example.schedule.Reopsitory.ScheduleRepository;
import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public String save(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getName(), requestDto.getTitle(), requestDto.getContent());
        schedule.setDay(requestDto.getDay());
        schedule.setPw(requestDto.getPw());

        Schedule saved = scheduleRepository.save(schedule);
        return "일정 저장 완료. ID: " + saved.getId();
    }

    public Schedule findEntityById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("일정이 존재하지 않습니다: " + id));
    }

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream()
                .map(schedule -> new ScheduleResponseDto(schedule, null)) // 댓글은 나중에 주입
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = findEntityById(id);
        return new ScheduleResponseDto(schedule, null);
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = findEntityById(id);
        if (schedule.getPw() != requestDto.getPw()) {
            throw new SecurityException("비밀번호가 일치하지 않습니다.");
        }

        schedule.setTitle(requestDto.getTitle());
        schedule.setContents(requestDto.getContent());
        schedule.setDay(requestDto.getDay());
        schedule.setName(requestDto.getName());

        return new ScheduleResponseDto(schedule, null);
    }

    @Transactional
    public void delete(Long id) {
        scheduleRepository.deleteById(id);
    }
}
