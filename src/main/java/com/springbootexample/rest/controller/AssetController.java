package com.springbootexample.rest.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.springbootexample.rest.model.Asset;
import com.springbootexample.rest.repository.AssetRepository;



@RestController
@RequestMapping(value = "api/v1/")
public class AssetController {
    
	@Autowired
	private AssetRepository assetRepository; 
	
	@RequestMapping(value="assets",method=RequestMethod.GET)
	public List<Asset> list(){
		return assetRepository.findAll();	
	}
	
	@RequestMapping(value="assets",method=RequestMethod.POST)
	public Asset create(@RequestBody Asset asset) {
		return assetRepository.saveAndFlush(asset);
	}
	
	@RequestMapping(value="assets/{id}",method=RequestMethod.GET)
	public Asset get(@PathVariable Long id) {
		return assetRepository.findOne(id);
	}
	
	@RequestMapping(value="assets/{id}",method=RequestMethod.PUT)
	public Asset update(@PathVariable Long id,@RequestBody Asset asset) {
		Asset existingAsset=assetRepository.findOne(id);
		BeanUtils.copyProperties(asset,existingAsset);
		return assetRepository.saveAndFlush(existingAsset);
	}
	
	@RequestMapping(value="assets/{id}",method=RequestMethod.DELETE)
	public Asset delete(@PathVariable Long id) {
		Asset existingAsset=assetRepository.findOne(id);
		assetRepository.delete(existingAsset);
		return existingAsset;
	}
}