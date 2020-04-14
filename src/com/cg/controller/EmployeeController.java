package com.cg.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.beans.AuthException;
import com.cg.beans.Employee;
/**
 * 
 * @author Gagandeep
 * @time 7:21:27 pm
 * @date 14-Apr-2020
 */
@Controller
@RequestMapping("/employee-module")
public class EmployeeController 
{
    @RequestMapping(value="/getAllEmployees", method = RequestMethod.GET)
    public String welcome(Model model) 
    {
        throw new NullPointerException();
    	
//        throw new AuthException(new Date(), "Something bad happened dude !! Run Away :-(");
        // Dispatcher Servlet will expect a ViewResolver name or View name but he gets 
        // Exception thrown from this function
    }
    
    @RequestMapping("/hello")  
    public String display(Model m)  
    {  
        m.addAttribute("emp", new Employee());  
        return "viewpage";  
    }  
    @RequestMapping("/helloagain")  
    public String submitForm( @Valid @ModelAttribute("emp") Employee e, BindingResult br)  
    {  
        if(br.hasErrors())  
        {  
            return "viewpage";  
        }  
        else  
        {  
        return "final";  
        }  
    }
}