package info.zhiqing.forus.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhiqing on 17-7-29.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to Forus!";
    }

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello";
    }
}
