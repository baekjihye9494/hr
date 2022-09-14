package com.gd.hr.service;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.gd.hr.vo.Region;

@Controller
public interface IRegionService {
	
	//기본 CRUD mapper에서 받아 쓸 서비스
	List<Region> getRegionList();
	Region modifyRegionOne(int regionId);
	int addRegion(Region region);
	int removeRegion(int regionId);
	int modifyRegion(Region region);
	
}
