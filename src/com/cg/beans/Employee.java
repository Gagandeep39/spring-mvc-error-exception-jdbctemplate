package com.cg.beans;

import javax.validation.constraints.Size;
/**
 * 
 * @author Gagandeep
 * @time 7:21:21 pm
 * @date 14-Apr-2020
 */
public class Employee {
	@Size(min=1,message="required")  
    private String name;  
    @Size(min=1,message="required")  
    private String pass;  
      
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getPass() {  
        return pass;  
    }  
    public void setPass(String pass) {  
        this.pass = pass;  
    }     
}
