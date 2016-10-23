package com.demo.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class StudentController {  
   
    @RequestMapping("/helloWorld")  
    public String helloWorld(Model model) {  
        String word0 = "Hello ls录视频";  
        String word1 = "World!";  
        //将数据添加到视图数据容器中  
        model.addAttribute("word0",word0);  
        model.addAttribute("word1",word1);  
        System.out.println(111);
        return "Hello.ftl";  
    }  
    @RequestMapping("/index")  
    public String index(Model model) {  
        String word0 = "Hello ls录视频";  
        String word1 = "World!";  
        //将数据添加到视图数据容器中  
        model.addAttribute("word0",word0);  
        model.addAttribute("word1",word1);  
        return "index.ftl";  
    }  
}  