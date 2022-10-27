package com.lyx.user.web;

import com.lyx.feign.pojo.User;
import com.lyx.user.config.FormatProperties;
import com.lyx.user.config.SharedProperties;
import com.lyx.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FormatProperties formatProperties;

    @Autowired
    private SharedProperties sharedProperties;

    @GetMapping("/now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(formatProperties.getDate()));
    }

    @GetMapping("/version")
    public String version(){
        return sharedProperties.getVersion();
    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth) throws InterruptedException {
        System.out.println("Truth: " + truth);
        return userService.queryById(id);
    }
}
