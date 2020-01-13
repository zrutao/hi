package com.zrt.hi.controller;

import com.zrt.hi.entity.Stu;
import com.zrt.hi.repository.HiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/hi")
public class HiController {

    private final static Logger logger= LoggerFactory.getLogger(HiController.class);

    @Autowired
    private HiRepository hiRepository;

    /**
     * 设置年龄
     */
    @GetMapping(value = "/name")
    public String name(@RequestParam(value = "name",required = false,defaultValue = "0") String my)
    {
        logger.info("嗨！听说你喜欢火");
        return "name:"+my;
    }
    /**
     * 插入一个学生信息
     */
    @GetMapping(value = "/create")
    public String create()
    {
        Stu stu=new Stu();
        stu.setName("zhaorutao");
        stu.setAge(23);
        hiRepository.save(stu);
        return "成功了";
    }

    /**
     * 查询全部
     */
    @GetMapping("/select")
    public List<Stu> select()
    {
        return hiRepository.findAll();
    }
}
