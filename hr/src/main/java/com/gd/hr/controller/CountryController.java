package com.gd.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.CountryService;
import com.gd.hr.service.ICountryService;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Controller
public class CountryController {
	@Autowired ICountryService countryService; // <- new RegionService()
	
	//리스트 보기
	@GetMapping	("/countryList")
	public String countryList(Model model) {
		List<Map<String, Object>> list = countryService.getCountryList();
		System.out.println(list);
		model.addAttribute("list", list); // request.setAttribute("list", list);
		
		return "countryList"; // ("regionList").forward(request, response);
	}
	
	
	//도시 추가 폼
	@GetMapping("/addCountryForm") //FORM
	public String addCountryForm(Model model) {
	   List<Region> list = countryService.addCountryForm();
	   model.addAttribute("list", list);
	   return "addCountryForm"; // <select><c:foreach var="region" items="${regionList}"><option>....
	}
	

	//도시 추가 액션
	@PostMapping("/addCountryForm") //ACTION
	public String addCountryForm(Country country) {//@requestParam int 받아도 자동으로 형변환
		
		System.out.println(country.toString());		
		countryService.addCountryAction(country);
		return "redirect:/countryList";
	}
	
	
	//도시 수정 폼
	@GetMapping("/modifyCountry") //FORM
	public String modifyCountry(Model model, @RequestParam(value = "countryId") String countryId) {
		//
		System.out.println(countryId + " <--controller/countryId");
		Country country = countryService.getCountry(countryId);
		model.addAttribute("country", country);
		//
		System.out.println(country + " <--controller/country");
		return "modifyCountry";
	}
	
	//도시 수정 액션
	@PostMapping("/modifyCountry")
	public String modifyCountry(Country country) {

		System.out.println(country.toString());		
		countryService.modifyCountry(country);		
		return "redirect:/countryList";
		
		
	}


	////////삭제
	@GetMapping("/removeCountry")
	public String removeRegion(@RequestParam(value = "countryId") String countryId) {
		int row = countryService.removeCountry(countryId);
		System.out.println(row);

		return "redirect:/countryList"; // countryList로 direct
	}
		
}