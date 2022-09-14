package com.gd.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Location;
import com.gd.hr.vo.Region;

@Service
public class LocationService implements ILocationService {
	@Autowired LocationMapper locationMapper;
	@Autowired RegionMapper regionMapper; 
	@Autowired CountryMapper countryMapper;
//리스트
 	@Override
 	public List<Map<String, Object>> getLocationList() {
 		List<Map<String, Object>> list = locationMapper.selectLocationList();
 		
 		return list;
 	}
	
	//region > country 자동설정 추가폼
	@Override
	public Map<String, Object> addLocationForm() {
		Map<String, Object> resultMap = new HashMap<>();
		
		List<Region> regionList = regionMapper.selectRegionList();
		
		resultMap.put("regionList", regionList);
		
		return resultMap;
	}
	//추가폼
	@Override
	public int addLocation(Location location) {
		int row = locationMapper.insertLocation(location);
		return row;
	}
	//추가액션
	@Override
	public int addLocationAction(Location location) {
		// TODO Auto-generated method stub
		System.out.println(location);
		int row = locationMapper.insertLocation(location);
		return row;

	}
	//수정 action
	@Override
	public int modifyLocation(Location Location) {
		return locationMapper.updateLocation(Location);
	}
	//수정 form
	@Override
	public Location getLocation(int locationId) {
		return locationMapper.selectLocationOne(locationId);
	}

	//삭제
	@Override
	public int removeLocation(int locationId) {
		// TODO Auto-generated method stub
		return locationMapper.deleteLocation(locationId);
	}

	
	
	
	
}
