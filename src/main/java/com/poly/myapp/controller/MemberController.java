package com.poly.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.myapp.model.dto.MemberDTO;
import com.poly.myapp.model.service.MemberService;

import sun.util.logging.resources.logging;

@RequestMapping("/member/*")
@Controller
public class MemberController {

	private MemberService memberService;
	@Autowired(required = true)
	public MemberController(MemberService memberService ) {
		this.memberService = memberService;
	}
	
	@GetMapping("/select")
	public List<MemberDTO> selectMember(Model model) {
		List<MemberDTO> memberInfo = memberService.selectMember();
		model.addAttribute("memberInfo", memberInfo);
		System.out.println(memberInfo);
		return memberInfo;
		
	}
}
