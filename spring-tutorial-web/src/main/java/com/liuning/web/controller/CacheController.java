package com.liuning.web.controller;

import com.liuning.cache.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CacheController {

	@Resource
	private MemberService memberService;

	@RequestMapping(value = "/userName", method = RequestMethod.GET)
	public String getUserName() {

		return memberService.getUserName();
	}

}
