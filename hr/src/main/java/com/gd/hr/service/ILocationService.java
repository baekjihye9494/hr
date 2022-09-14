package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Location;

public interface ILocationService {
	//list
	List<Map<String, Object>> getLocationList();
	
	//insert
	int addLocation(Location location);
	Map<String, Object> addLocationForm();
	int addLocationAction(Location Location);
	
	//update
	int modifyLocation(Location Location); //수정
	Location getLocation(int locationId);//수정액션
	
	//delete
	int removeLocation(int locationId);
	
	
}
