/**
 * 
 */
package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.beans.Emp;
import com.cg.dao.EmpDao;

/**
 * 
 * @author Gagandeep
 * @time 7:20:55 pm
 * @date 14-Apr-2020
 */
@Controller
@RequestMapping(value="/loginCtrl") //class level annotation
public class LoginController {
	
	  @Autowired    
	    EmpDao dao;

	@RequestMapping(value="/ValidateLogin") //method-level
	public String login(
			@RequestParam("txtName") String username,
			@RequestParam("txtPassword") String password,
			Model model) {
		System.out.println("Inside Login Function");
		if(username.equals("admin") && 
		password.equals("admin")){
			String valid = "Welcome " + username + " You are a valid user ";
			model.addAttribute("message", valid);
			return "valid";
		} else {
			String invalid = "Welcome " +username +" you are invalid";
			model.addAttribute("message",invalid);
			return "invalid";
		}
	}

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
	
	@RequestMapping("/empform")
	public ModelAndView showform(){
//		model.addAttribute("command", new Emp());
//		return "empform";
		return new ModelAndView("empform","command",new Emp());
	}
	
//	@RequestMapping("/save")
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		//write code to save emp object
		System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());
		dao.save(emp);
//		return new ModelAndView("viewemp","command",emp);
		return new ModelAndView("redirect:/loginCtrl/viewemp.obj");
	}
	
	@RequestMapping("/viewemp")
	public ModelAndView viewemp(){
		//write the code to get all employees from DAO
		//writing manual code for easy understanding
//		List<Emp> list=new ArrayList<Emp>();
//		list.add(new Emp(1,"rahul",35000f,"S.Engineer"));
//		list.add(new Emp(2,"aditya",25000f,"IT Manager"));
//		list.add(new Emp(3,"sachin",55000f,"Care Taker"));
		
		List<Emp> list=dao.getEmployees();    
//        m.addAttribute("list",list);  
		
		return new ModelAndView("viewemp","list",list);
	}
	 @RequestMapping(value="/editemp/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        Emp emp=dao.getEmpById(id);    
	        m.addAttribute("command",emp);  
	        return "empeditform";    
	    }    
	    /* It updates model object. */    
	    @RequestMapping(value="/editemp/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("emp") Emp emp){    
	        dao.update(emp);    
	        return "redirect:/loginCtrl/viewemp.obj";    
	    }    
	    /* It deletes record for the given id in URL and redirects to /viewemp */    
	    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.delete(id);    
	        return "redirect:/loginCtrl/viewemp.obj";    
	    }  
}
