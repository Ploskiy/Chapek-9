package by.ploskiy.controller;

import by.ploskiy.entitys.TaskTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {

//    @ModelAttribute("allTasksEnum")
//    public TaskTypeEnum allTasksEnum() {
//        return taskTypeEnum;
//    }

//    @ModelAttribute("allTasksEnum")
//    public List<TaskTypeEnum> allTasksEnum() {
//        List<TaskTypeEnum> allTasksEnumList = new ArrayList<TaskTypeEnum>(Arrays.asList(TaskTypeEnum.values()));
//        return allTasksEnumList;
//    }

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }
}
