package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("클릭")
    public String 클릭(Model model){
        model.addAttribute("data", "데이터 받기");
        return "클릭";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name",required = true) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //위에랑 같은데 소스보기하면 그냥 리턴값 그대로 들어가있음
    @GetMapping("hello-string")
    @ResponseBody
    public String hellostring(@RequestParam("name") String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
