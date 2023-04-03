/**
 * 
 */
package com.mneumann1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mneumann1.model.LoginModel;

import jakarta.validation.Valid;

/**
 * @author MNEUMANN1
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/")
	public String displayLoginForm(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return "loginForm.html";
	}
	
	
	@PostMapping("/processLogin")
	public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("loginModel", loginModel);
			return "loginForm.html";
		}
		else {
			model.addAttribute("loginModel", loginModel);	
			return "loginResults.html";
		}
		
	}

}
