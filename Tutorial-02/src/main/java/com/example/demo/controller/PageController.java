package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index( ) {
		return "viral";
	}
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	@RequestMapping(value= {"/challenge" , "challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "KB");
		}
		
		return "challenge";
	}
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam (value = "a" , defaultValue = "0") int a, 
								@RequestParam (value = "b" , defaultValue = "0") int b, Model model) {
		
		String x = "h";
		String y = "m";
		String z = " ";
		String hasil = "";
		
		model.addAttribute("a" , a);
		model.addAttribute("b" , b);
		if (a==0) {
			a=1;
		}

		if (a==0 && b==0) {
		 hasil+=x+y;
		}
		else {
			y = "";
			
			for(int i=a; i>0 ;i--) {
				y+="m";
				hasil = x+y;
			}
			String n = hasil;
		
			for(int j=b; j>0; j--) {
				hasil = z+= " " + n;
			}
			
		}
		
		
		
		model.addAttribute("hasil" , hasil);
		return "viralGenerator";
		
	}
	
	
	
	
		
		
	
	
	
}
