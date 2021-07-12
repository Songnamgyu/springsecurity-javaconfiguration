package com.poly.myapp.controller;

import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.myapp.config.jwt.JwtTokenProvider;
import com.poly.myapp.model.dao.MemberMapper;
import com.poly.myapp.model.dto.User;
import com.poly.myapp.model.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api(tags = {"1. Sign"})

@RequiredArgsConstructor

@RestController

@RequestMapping(value = "/v1")

public class SignController {



	private  MemberMapper memberMapper;

	private JwtTokenProvider jwtTokenProvider;

	private MemberService responseService;

	private  PasswordEncoder passwordEncoder;



	@ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")

	@GetMapping(value = "/signin")

	public SingleResult<String> signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,

			@ApiParam(value = "비밀번호", required = true) @RequestParam String password) {


		User user = memberMapper.findByUid(id);

		if (!passwordEncoder.matches(password, user.getPassword()))
		return responseService.getSingleResult(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));

	}



	@ApiOperation(value = "가입", notes = "회원가입을 한다.")

	@GetMapping(value = "/signup")

	public CommonResult signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,

			@ApiParam(value = "비밀번호", required = true) @RequestParam String password,

			@ApiParam(value = "이름", required = true) @RequestParam String name) {



		userJpaRepo.save(User.builder()

				.uid(id)

				.password(passwordEncoder.encode(password))

				.name(name)

				.roles(Collections.singletonList("ROLE_USER"))

				.build());

		return responseService.getSuccessResult();

	}

}


