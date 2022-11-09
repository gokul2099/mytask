package com.file.file.property.controller.service;

import org.springframework.stereotype.Service;

@Service

public class fileservice {
public int add(int n1,int n2) {
	int n=n1+n2;
	return n;
}
public int sub(int n1,int n2) {
	int n=n1-n2;
	return n;}

public int mul(int n1,int n2) {
	int n=n1*n2;
	return n;}
public int div(int n1,int n2) {
	int n=n1/n2;
	return n;
	}
}
