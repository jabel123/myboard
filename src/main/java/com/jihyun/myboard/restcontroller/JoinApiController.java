package com.jihyun.myboard.restcontroller;

import com.jihyun.myboard.entity.Exercise;
import com.jihyun.myboard.service.ExerciseService;
import com.jihyun.myboard.service.JoinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class JoinApiController {
    private final JoinService joinService;

    @Autowired
    public JoinApiController(JoinService joinService) {
        this.joinService = joinService;
    }

    // join.html
    @GetMapping("/api/members/{username}")
    public int checkUsernameExist(@PathVariable("username") String username) {
        int usernameExist = joinService.checkUsernameExist(username);

        return usernameExist;
    }

}
