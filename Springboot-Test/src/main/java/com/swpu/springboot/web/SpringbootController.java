package com.swpu.springboot.web;

import com.swpu.springboot.model.Student;
import com.swpu.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class SpringbootController {
    /*@RequestMapping("/springboot/hello")
    @ResponseBody
   public String springbootTest(){
       return "Hello Springboot";
   }*/
    @Autowired
    private StudentService studentService;


    @GetMapping("/queryStudent")
    @ResponseBody
    public Object studentTest(Integer id){
        log.info("-----------查询开始------------");
        Student student = studentService.selectStudentById(id);
        log.info("-----------查询结束------------");
        return student;
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public Object studentTest2(Integer id,String name,Integer age){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        studentService.insertStudentById(student);
        return "add_new_student:"+student.getName();
    }

    @GetMapping("/studentRestful/{id}")
    @ResponseBody
    public Object studentTest3(@PathVariable("id") Integer id){
        Student student = studentService.selectStudentById(id);
        return student;
    }

    /*@RequestMapping("/redisPut")
    @ResponseBody
    public Object redisPut(String key,String value){
        studentService.putRedis(key,value);
        return "Put,OK!!";
    }
    @GetMapping("/redisGet")
    @ResponseBody
    public Object redisGet(String key){
        studentService.GetRedis(key);
        return "Get,OK!!";
    }*/

}
