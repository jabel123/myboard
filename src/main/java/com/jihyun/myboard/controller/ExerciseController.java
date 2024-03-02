package com.jihyun.myboard.controller;

import com.jihyun.myboard.entity.Exercise;
import com.jihyun.myboard.service.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercise")
    public String exersice(Model model,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "keyword",  required = false, defaultValue = "") String keyword) {
        int pageSize = 5; // 페이지당 게시글 수
        int totalCount = exerciseService.getContentCount(keyword);
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        int offset = (page - 1) * pageSize;
        List<Exercise> contentList = exerciseService.keywordSelect(offset, keyword);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("contentList", contentList);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        // CTL + Shift + R 정해진 문자열 바꾸기
        // CTL + Shift + F 전체 찾기

        log.info(keyword);

        return "/exercise";
    }

    @PostMapping("/exercise")
    public String insertEx(@RequestParam String content,
                           @RequestParam String writer) {
        exerciseService.insertEx(content, writer);
        log.info("등록한 내용: {}, {}", content, writer);
        return "redirect:/exercise";
    }

    @PostMapping("/deleteEx")
    public String deleteEx(@RequestParam String id,
                           @RequestParam String content,
                           @RequestParam String writer) {
        exerciseService.deleteEx(id, content, writer);
        log.info("삭제된 내용: {}, {}, {}", id, content, writer);
        return "redirect:/exercise";
    }

    @GetMapping("/exercise/detail/{idValue}")
    public String exerciseSelectDetail(@PathVariable("idValue") String idValue, Model model,
                                       @RequestParam(value = "page", defaultValue = "1") int page) {
        Exercise exercise = (exerciseService.exerciseSelectDetail(idValue));
        model.addAttribute("exercise", exercise);
        return "/exerciseDetail";
    }

    @PostMapping("/exercise/detail")
    public String exerciseUpdateDetail(@RequestParam String id,
                                       @RequestParam String content,
                                       @RequestParam String writer) {

        exerciseService.exerciseUpdateDetail(id, content, writer);
        return "redirect:/exercise";
    }
}
