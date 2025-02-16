package com.example.Springboot3SecuityDemo.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.Springboot3SecuityDemo.service.impl.MemberServiceImpl;

@Component
public class AssistUtil {
	
	@Autowired
	MemberServiceImpl memberService;
	
	//取號機
	public int getSerial(String tableName){
		int max = 0;
		switch(tableName){
			case "member":
				max = memberService.getMaxId();
				System.out.println("member max:" + max);
			case "product":
				max = memberService.getMaxId();
				System.out.println("member max:" + max);
		}
		return (max+1);
	}
}
