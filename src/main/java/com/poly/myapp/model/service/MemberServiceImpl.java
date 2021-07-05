package com.poly.myapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.myapp.model.dao.MemberMapper;
import com.poly.myapp.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;
	
	@Autowired(required = true)
	public MemberServiceImpl(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	@Override
	public List<MemberDTO> selectMember() {
		// TODO Auto-generated method stub
		return memberMapper.selectMember();
	}

}
