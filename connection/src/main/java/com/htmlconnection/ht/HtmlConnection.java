package com.htmlconnection.ht;


	import java.util.Map;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/run/")
	public class HtmlConnection {

	@RequestMapping(value = "api", method = RequestMethod.GET)
	public ResponseEntity<?> loginMethod(@RequestParam Map<String, String> reqParam) throws Exception {
	System.out.println(reqParam);
	String uName = reqParam.get("name");
	String uPass = reqParam.get("pass");

	String userName = "gokul";
	String password = "243";

	if (userName.equals(uName) && password.equals(uPass)) {
	reqParam.put("Status", "Login Successfully");
	} else {
	reqParam.put("Status", "Incorrect Credentials");
	}

	return new ResponseEntity<>(reqParam, HttpStatus.OK);

	}
	}

