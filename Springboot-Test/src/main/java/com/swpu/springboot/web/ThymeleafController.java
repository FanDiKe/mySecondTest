package com.swpu.springboot.web;

import com.swpu.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {
    /*@RequestMapping(value = "/message1")
    public String message1(Model model) {
        model.addAttribute("data1","SpringBoot集成Thymeleaf模版引擎1");
        return "message";
        //用的thymeleaf自带的视图解析器
    }*/
   /* @RequestMapping("/message")
    public ModelAndView message2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data2","SpringBoot集成Thymeleaf模版引擎2");
        modelAndView.setViewName("message2");
        return modelAndView;
    }*/
    @RequestMapping("/message3")
    public String message3(HttpServletRequest request,Model model){
        model.addAttribute("data1","SpringBoot集成Thymeleaf模版引擎1");
        User user = new User();
        user.setId(1001);
        user.setUsername("zhangsan");
        model.addAttribute("user",user);

        request.getSession().setAttribute("data","sessionData");

        return "message";
    }

    @RequestMapping("/message4")
    public ModelAndView message3(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data2","SpringBoot集成Thymeleaf模版引擎2");
        User user = new User();
        user.setId(1002);
        user.setUsername("lisi");
        modelAndView.addObject("user",user);
        modelAndView.setViewName("message");
        return modelAndView;
    }

}
