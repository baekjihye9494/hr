package com.gd.hr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.ILocationService;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Location;

@Controller
public class LocationController {
	@Autowired ILocationService locationService;
	
	//리스트 보기
	@GetMapping	("/locationList")
	public String locationList(Model model) {
		List<Map<String, Object>> list = locationService.getLocationList();
		System.out.println(list);
		model.addAttribute("list", list); // request.setAttribute("list", list);
		
		return "locationList"; // ("regionList").forward(request, response);
	}
	
	//추가폼
	@GetMapping("/addLocation")
	public String addLocation(Model model) {
		Map<String, Object> map = locationService.addLocationForm();
		model.addAttribute("regionList", map.get("regionList"));
		return "addLocation";
	}
	//추가액션
	@PostMapping("/addLocation") //ACTION
	public String addLocation(Location location) {//@requestParam int 받아도 자동으로 형변환
		
		System.out.println(location.toString());		
		locationService.addLocationAction(location);
		return "redirect:/locationList";
	}


	
	//도시 수정 폼
	@GetMapping("/modifyLocation") //FORM
	public String modifyLocation(Model model, @RequestParam(value = "locationId") int locationId) {
		//
		System.out.println(locationId + " <--controller/locationId");
		Location location = locationService.getLocation(locationId);
		model.addAttribute("location", location);
		//
		System.out.println(location + " <--controller/location");
		return "modifyLocation";
	}
	
	//도시 수정 액션
	@PostMapping("/modifyLocation")
	public String modifyLocation(Location location) {

		System.out.println(location.toString());		
		locationService.modifyLocation(location);		
		return "redirect:/LocationList";
		
		
	}
	
	////////삭제
	@GetMapping("/removeLocation")
	public String removeLocation(@RequestParam(value = "locationId") int locationId) {
		int row = locationService.removeLocation(locationId);
		System.out.println(row);
	
		return "redirect:/LocationList"; // countryList로 direct
	}
	
}
