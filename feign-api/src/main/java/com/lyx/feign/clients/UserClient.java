package com.lyx.feign.clients;

import com.lyx.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("gateway")
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id, @RequestParam("authorization") String authorization);
}
