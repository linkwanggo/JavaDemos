package com.linkwanggo.demo.controller;

import com.linkwanggo.demo.exception.CommonException;
import com.linkwanggo.demo.model.response.ExceptionCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("test")
    public void test() {
        throw new CommonException(ExceptionCode.INVALID_PARAM);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Long> test2(@PathVariable("id") Long id) {
        return ResponseEntity.ok(id);
    }
}
