package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Location;

@Mapper
public interface LocationMapper {
	//리스트
	List<Map<String, Object>> selectLocationList();
	
	//추가
	int insertLocation(Location location);
	
	//수정
	int updateLocation(Location location);
	Location selectLocationOne(int locationId);
	
	//삭제
	int deleteLocation(int locationId);	
}
