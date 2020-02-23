package com.zrt.hi.controller;

import com.zrt.hi.entity.Result;
import com.zrt.hi.entity.Stu;
import com.zrt.hi.repository.HiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
        logger.info("嗨！听说你喜欢火！！！！！");
        return "name:"+my;
    }
    /**
     * 插入一个学生信息
     */
    @GetMapping(value = "/create")
    public Result<Stu> create(@Valid Stu s, BindingResult bindingResult)
    {

        Result result=new Result();
        Stu stu=new Stu();
        if(bindingResult.hasErrors())
            {
                result.setCode(0);
                result.setMsg("失败");
                return result;
            }
        stu.setName(s.getName());
        stu.setAge(s.getAge());
        hiRepository.save(stu);
        result.setCode(1);
        result.setMsg("成功");
        result.setData(stu);
        return result;
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
