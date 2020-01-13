package com.zrt.hi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hi")
public class HiController {

    private final static Logger logger= LoggerFactory.getLogger(HiController.class);
    /**
     * 设置年龄
     */
    @GetMapping(value = "/name")
    public String name(@RequestParam(value = "name",required = false,defaultValue = "0") String my)
    {
        logger.info("嗨！听说你喜欢火");
        return "name:"+my;
    }
}
