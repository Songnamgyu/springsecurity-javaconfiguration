package com.poly.myapp.model.dao;

import java.util.List;

import com.google.common.base.Optional;
import com.poly.myapp.model.dto.MemberDTO;
import com.poly.myapp.model.dto.User;

public interface MemberMapper {

	List<MemberDTO> selectMember();

	Optional<User> findById(Long valueOf);

}
