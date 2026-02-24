package br.com.wandeilson.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.info("This is a INFO log");
        logger.debug("This is a DEBUG log");
        logger.warn("This is a WARN log");
        logger.error("This is a ERROR log");

        return "Logs generated successfully";
    }
}
