package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {
    Logger logger = LogManager.getLogger("collect");

    @PostMapping("")
    public ResponseEntity<?> collectData() {

        ThreadContext.put("myKey", "myValue");

        logger.debug("homeController ==============");
        log.debug("ddjdjdjdjdjdjdjdj");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
