package com.gd.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Country;

@Mapper //
public interface CountryMapper {
	//리스트
	List<Map<String, Object>> selectCountryList();

	//추가
	int insertCountry(Country country);

	//수정
	int updateCountry(Country country);
	Country selectCountryOne(String countryId);

	//삭제
	int deleteCountry(String countryId);

	//regionId 가져오는 리스트
	List<Country> selectCountryIdAndNameList(int regionId);

	
}
