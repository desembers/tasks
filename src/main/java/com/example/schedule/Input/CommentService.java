package com.example.schedule.Input;

import com.example.schedule.Reopsitory.ComponentRepository;
import com.example.schedule.Reopsitory.ScheduleRepository;
import com.example.schedule.dto.CommentRequestDto;
import com.example.schedule.dto.CommetResponseDto;
import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ComponentRepository componentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommetResponseDto createComment(Long scheduleId, CommentRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다."));

        if (componentRepository.countBySchedule(schedule) >= 10) {
            throw new IllegalStateException("댓글은 최대 10개까지만 작성할 수 있습니다.");
        }

        Comment comment = new Comment(
                requestDto.getContent(),
                requestDto.getAuthor(),
                requestDto.getPassword(),
                schedule
        );

        Comment saved = componentRepository.save(comment);
        return new CommetResponseDto(saved);
    }

    public List<CommetResponseDto> getCommentsByScheduleId(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다."));

        return componentRepository.findBySchedule(schedule)
                .stream()
                .map(CommetResponseDto::new)
                .toList();
    }
}
