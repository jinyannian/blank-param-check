package org.mudskipper.example.controller;

import org.mudskipper.blankparamcheck.annotation.BlankParameterCheck;
import org.mudskipper.blankparamcheck.annotation.Ignored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@BlankParameterCheck
public class TestController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/get")
    public String get(String abc, @Ignored String def){
        logger.info(abc);
        logger.info(def);
        return "";
    }
    @RequestMapping("/get2")
    @Ignored
    public String get2(String abc, String def){
        logger.info(abc);
        logger.info(def);
        return "";
    }
}
