package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.service.UserService;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiModel(value="User RestController")
@RequiredArgsConstructor
@RestController
@RequestMapping("/User")
public class UserRestController {

    private final UserService userService;

    private final String SUCCESS = "SUCCESS";
    private final String FAIL = "FAIL";
}
