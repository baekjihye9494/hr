package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.gd.hr.vo.Region;

@Mapper //레파지스토리 퍼블릭 클래스  sss implements RegionMapper{...}
public interface RegionMapper {
	
	//기본 CRUD
	List<Region> selectRegionList(); //리스트 메서드
	int insertRegion(Region region); //추가 메서드
	int deleteRegion(int regionId);	 //삭제 메서드
	int updateRegion(Region region); //수정 메서드
	Region selectRegionOne(int regionId);//수정 상세보기
	
}
