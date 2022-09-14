package com.gd.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Region;

@Controller
public class RegionController {
	@Autowired IRegionService regionServcie; // <- new RegionService()
	

	//리스트 보기
	@GetMapping	("/regionList")
	public String regionList(Model model) {
		List<Region> list = regionServcie.getRegionList();
		model.addAttribute("list", list); // request.setAttribute("list", list);
		System.out.println(list);
		return "regionList"; // ("regionList").forward(request, response);
	}
	
	
	//게시글 상세보기 폼
	@GetMapping("modifyRegionOne")
	public String modifyRegionOne(Model model, @RequestParam(value="regionId") int regionId ) {
		model.addAttribute("r", regionId); 
		return "modifyRegionOne";
	}
	
	//게시글 상세보기 액션
	@PostMapping("/modifyReigonOne")
	public String modifyReigonOne (int regionId) {
				
		regionServcie.modifyRegionOne(regionId);
		return "redirect:/modifyRegionOne";
	}
	
	//게시글 추가 폼
	@GetMapping("/addRegion") //FORM
	public String addRegion(Model model, Region region ) {
		System.out.println(region);
		
		model.addAttribute("r",region);
		
		return "addRegion";
	}
	//게시글 추가 액션
	@PostMapping("/addRegion") //ACTION
	public String addRegion(Region region) {//@requestParam int 받아도 자동으로 형변환
		System.out.println(region);
		
		int row= regionServcie.addRegion(region);
		
		
		return "redirect:/regionList";
	}
	
	//게시글 수정 폼	
	@GetMapping("/modifyRegion") //FORM
	public String modifyRegion(Model model, Region region ) {
		
		System.out.println(region);
		
		model.addAttribute("r",region);
		
		return "modifyRegion";
	}
	
	//게시글 수정 액션
	@PostMapping("/modifyRegion") //ACTION
	public String modifyRegion(Region region ) {
		
		int row= regionServcie.modifyRegion(region);
		
		return "redirect:/regionList";
		
		
	}
	
	
	//삭제
	@GetMapping("/removeRegion")
	public String removeRegion(@RequestParam(value="regionId") int regionId ) {
		
		int row= regionServcie.removeRegion(regionId);
		
		return "redirect:/regionList";
		
		
	}
}