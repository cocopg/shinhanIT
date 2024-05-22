package com.shinhan.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shinhan.myapp.model.AccountDAOMybatis;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl {
	@Autowired
	AccountDAOMybatis dao;
	
	public void update() {
		dao.update1();
		dao.update2();
	}
}
