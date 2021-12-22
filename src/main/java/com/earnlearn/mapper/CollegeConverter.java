package com.earnlearn.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.earnlearn.model.CollegeDTO;
import com.earnlearn.entity.College;


public class CollegeConverter {

	public CollegeDTO entityToDto(College college) {
		CollegeDTO dto = new CollegeDTO();
		dto.setCollegeId(college.getCid());
		dto.setName(college.getName());
		dto.setCreatedOn(college.getCreatedOn());
		dto.setModifiedOn(college.getModifiedOn());
		return dto;
	}

	public List<CollegeDTO> entityToDto(List<College> college) {
		return college.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
}
