package com.example.Springboot3SecuityDemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Springboot3SecuityDemo.model.DemoMember;
import com.example.Springboot3SecuityDemo.service.MemberService;

@Controller
public class MainController {

	@Autowired
	MemberService memberService;
	
	
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model){
    	DemoMember member = new DemoMember();
    	model.addAttribute("member", member);
        return "register";
    }
    
    @PostMapping("/registerResult")
    public ResponseEntity<?> registerResult(Model model,@RequestBody DemoMember member){
    	int count = 0;
    	try {
    		memberService.saveMember(member);
        	model.addAttribute("member", member);
    	}catch(Exception ex) {
    		count = 1;
    	}
        return ResponseEntity.ok(count);
    }
    @PostMapping("/checkAccountExist")
	public ResponseEntity<?> checkAccountExist(@RequestBody String account) {
		int count = memberService.checkAccountExist(account);
		return ResponseEntity.ok(count);
	}
    
    @GetMapping("/latestNews")
    public String latestNews() {
    	System.out.println("run latestNews");
		return "latestNews";
	}
}
