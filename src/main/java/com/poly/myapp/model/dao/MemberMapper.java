package com.poly.myapp.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poly.myapp.model.dto.MemberDTO;

public interface MemberMapper {

	List<MemberDTO> selectMember();

}
