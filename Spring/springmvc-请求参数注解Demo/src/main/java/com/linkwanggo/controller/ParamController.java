package com.linkwanggo.controller;

import com.linkwanggo.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
    public String saveUser(User user) {
        System.out.println(user);
        return "success";
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam("username") String username) {
        return "success";
    }

    @PostMapping("/requestBody")
    public String requestBody(@RequestBody User user) {
        return "success";
    }

    @GetMapping("/pathVariable/{username}")
    public String pathVariable(@PathVariable("username") String username) {
        return "success";
    }

    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader("user-agent") String userAgent) {
        return "success";
    }

    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String JSESSIONID) {
        return "success";
    }
}
