package by.ploskiy.controller;

import by.ploskiy.entitys.TaskTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }
}
