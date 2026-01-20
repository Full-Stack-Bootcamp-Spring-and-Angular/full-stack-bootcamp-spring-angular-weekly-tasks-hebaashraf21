package com.myApp.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController
{
    public HomeController() {
        System.out.println(">>> HomeController LOADED <<<");
    }

    @RequestMapping("/showForm")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(
            @RequestParam("firstName") String firstName ,
            @RequestParam("lastName") String LastName ,
            @RequestParam("email") String email ,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdate,
            @RequestParam("city") String city ,
            Model model)
    {

        //step2: add name to model
        model.addAttribute("firstName" , firstName);
        model.addAttribute("lastName" , LastName);
        model.addAttribute("email",email);
        model.addAttribute("birthdate",birthdate);
        model.addAttribute("city",city);

        //step3: return view page
        return "resultPage";
    }


}


