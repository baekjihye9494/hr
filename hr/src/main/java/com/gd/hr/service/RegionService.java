package com.gd.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class RegionService implements IRegionService {
	// DI : 객체를 직접 생성하지않고 스프링 프레임워크를 통해(bean객체) 주입
	// Interface 타입을 사용
	@Autowired RegionMapper regionMapper;


	//수정 처리
	@Override
	public int modifyRegion(Region region) {
		// TODO Auto-generated method stub
		return regionMapper.updateRegion(region);
	}
	
	//삭제 처리
	@Override
	public int removeRegion(int regionId) {
		// TODO Auto-generated method stub
		return regionMapper.deleteRegion(regionId);
	}

	
	//추가 처리
	@Override
	public int addRegion(Region region) {
		// TODO Auto-generated method stub
		return regionMapper.insertRegion(region);
	}

	
	//리스트 보기
	@Override
	public List<Region> getRegionList() {
		// TODO Auto-generated method stub
		return regionMapper.selectRegionList();
	}

	//상세보기
	@Override
	public Region modifyRegionOne(int regionId) {
		// TODO Auto-generated method stub
		return regionMapper.selectRegionOne(regionId);
	}

}