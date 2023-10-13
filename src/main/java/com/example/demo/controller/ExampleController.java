package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/ex")
public class ExampleController {

    Logger logger = LogManager.getLogger("collect");


    @PostMapping("")
    public ResponseEntity<?> collectData() {
        log.debug("ExampleController ==============");
        ThreadContext.put("mey", "myue");

        logger.debug("ddjdjdjdjdjdjdjdj");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
