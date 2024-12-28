package com.sprinbootDemo.jdbl_78_springboot;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
////api response can be response or a view
//@ResponseBody
@Service
@Repository
//@RestController  //combination of Controller + ResponseBody
public class DemoController {

    @GetMapping("/dummy")
    public ModelAndView dummyCall(){
      //return "dummyCall";
        ModelAndView modelAndView = new ModelAndView("dynamic-info.html");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Mohit","1"));
        personList.add(new Person("Rohit","2"));

        modelAndView.getModelMap().put("personList",personList);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD mm:hh:ss");

        //adding info to view
        modelAndView.getModelMap().put("date",simpleDateFormat.format(new Date()));
        return modelAndView;
    }
}
