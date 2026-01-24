package com.myApp.controller;

import com.myApp.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController
{

    @RequestMapping("/showForm")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel" , new UserModel());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String submitForm(@Valid @ModelAttribute("userModel") UserModel userModel , BindingResult result, Model model)
    {
        //to return back to the form page with the errors
        if(result.hasErrors())
            return "formPage";

        //step1: add bean to model
       model.addAttribute("userModelResult" , userModel);

       //step2: return view page
        return "resultPage";
    }
}