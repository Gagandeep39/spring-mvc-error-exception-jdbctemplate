/**
 * 
 */
package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author Gagandeep
 * @time 7:21:37 pm
 * @date 14-Apr-2020
 */
@Controller
@RequestMapping(value="/SignupCtrl") //class level
public class SignupController {
	
	
	@RequestMapping(value="/RegisterEmployee") //method-level
	public String signUp(
			@RequestParam("txtName") String username,
			@RequestParam("txtPassword") String password,
			@RequestParam("txtEmail") String email,
			Model model
			) {
			String valid = "Welcome " + username + ", " +email+", "+password;
			model.addAttribute("message", valid);
			return "valid";
		}
}
