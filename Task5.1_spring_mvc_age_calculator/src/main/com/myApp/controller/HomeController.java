package com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController
{

    @RequestMapping("/showForm")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request , Model model)
    {
        //getting parameters from request
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));

        LocalDate birthDate = LocalDate.of(year,month,day);
        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthDate,currentDate);


        //adding data to the model
        model.addAttribute("year" , age.getYears());
        model.addAttribute("month" , age.getMonths());
        model.addAttribute("day" , age.getDays());

        //return the view with model
        return "resultPage";
    }
}
