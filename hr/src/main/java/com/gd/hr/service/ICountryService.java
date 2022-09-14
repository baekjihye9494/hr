package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

public interface ICountryService {

	List<Map<String, Object>> getCountryList(); //리스트
	
	List<Region> addCountryForm(); //추가
	List<Country> getCountryIdAndNameList(int regionId);
	int addCountryAction(Country country); //추가액션

	int modifyCountry(Country country); //수정
	Country getCountry(String countryId);//수정액션
	
	int removeCountry(String countryId);
	


}
