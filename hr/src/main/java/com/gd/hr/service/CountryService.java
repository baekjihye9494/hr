package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Service
@Transactional
//서비스에는 어떤 mapper가 와도 상관없지만 자기 서비스에는 자기 mapper만 부르는게 기본

public class CountryService implements ICountryService {   
   @Autowired RegionMapper regionMapper;
   @Autowired CountryMapper countryMapper;
	// DI : 객체를 직접 생성하지않고 스프링 프레임워크를 통해(bean객체) 주입
	// Interface 타입을 사용
   //리스트
 	@Override
 	public List<Map<String, Object>> getCountryList() {
 		List<Map<String, Object>> list = countryMapper.selectCountryList();
 		
 		return list;
 	}
 	
 	//추가 
	@Override //<region리스트도 같이 가져와야 하기때문에 리스트로 받는 값을 설정>
	public List<Region> addCountryForm() {
		//리턴에 시킬 곳 > 맵퍼의 insertCountry에 담아주고 받은 정보를 다 넣어야 하니깐 country 클래스를 매개변수로 받는다.
		
		List<Region> regionList = regionMapper.selectRegionList();
		return regionList;
	}	
	@Override
	public int addCountryAction(Country country) {
		
		System.out.println(country);
		int row = countryMapper.insertCountry(country);
		return row;
	}
 		
	//수정 action
	@Override
	public int modifyCountry(Country country) {
		return countryMapper.updateCountry(country);
	}
	//수정 form
	@Override
	public Country getCountry(String countryId) {
		return countryMapper.selectCountryOne(countryId);
	}
	
	//삭제
	@Override
	public int removeCountry(String countryId) {
		return countryMapper.deleteCountry(countryId);
	}
	


	@Override
	public List<Country> getCountryIdAndNameList(int regionId) {
		System.out.println("CountryServcie "+regionId);
		List<Country> list = countryMapper.selectCountryIdAndNameList(regionId);
		return list;
	}
	
}