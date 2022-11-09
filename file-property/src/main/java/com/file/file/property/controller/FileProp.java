package com.file.file.property.controller;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.file.file.property.controller.service.fileservice;

@RestController
@RequestMapping("/api/")
public class FileProp {
	

	@Autowired fileservice obj;

	@Value("${data}")
	private String data;

	@RequestMapping(value = "testAPI", method = RequestMethod.GET)
	public ResponseEntity<?> testApi(@RequestParam Map<String, String> map)throws Exception {

		System.out.println("i/p"+map);
		int ans = 0;
		
		try {
	      
	     String s=map.get("op").toString();

	int a=Integer.parseInt(map.get("n1").toString());
	int b=Integer.parseInt(map.get("n2").toString());
	switch (s) {
	case "add":
	ans = obj.add(a, b);
	break;
	case "sub":
	ans = obj.sub(a, b);
	break;
	case "multiply":
	ans = obj.mul(a, b);
	break;
	case "division":

	ans = obj.div(a, b);
	break;
	}
	   map.put("status ","success ");
		}
	catch(Exception e) {
	   
		map.put("status ","fail");
		System.out.println("o/p"+e);
	      }
		map.put("ans", Integer.toString(ans));
	    return new ResponseEntity<>(map, HttpStatus.OK);
	}
	/*@RequestMapping(value = "testAPILoad", method = RequestMethod.GET)
	public ResponseEntity<?> testApiLoad(@RequestParam Map<String, String> map)throws Exception {

		System.out.println("i/p"+map);
	    Properties best=new Properties();
		
		
		try {

	      FileInputStream f=new FileInputStream("â€ªC:\\Users\\deepi\\Downloads\\direction\\direction\\src\\main\\resources\\best.properties");

	      best.load(f);
		}
	catch(Exception e) {
	   e.printStackTrace();

	      }
		
	    return new ResponseEntity<>(best, HttpStatus.OK);
	}*/
	@RequestMapping(value = "load", method = RequestMethod.GET)
	public ResponseEntity<?> loadProperty(@RequestParam Map<String, String> requestParam) throws Exception {

	Properties prop = new Properties();

	prop.put("Id","101");
	prop.put("Name","deepi");
	prop.put("Designation","Software Developer");

	FileOutputStream out = new FileOutputStream("C:\\FileProprties\\filelog.properties");
	prop.store(out,"Details");

	try {
	// File f = new File("D:\\FileOperations\\propFile.properties");
	FileInputStream fin = new FileInputStream("data");
	prop.load(fin);

	} catch (Exception e) {
	System.out.println((e));
	}

	return new ResponseEntity<>(prop , HttpStatus.OK);
	}




	}


