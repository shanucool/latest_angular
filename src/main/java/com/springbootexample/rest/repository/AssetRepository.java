package com.springbootexample.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootexample.rest.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long>{

	Asset findOne(Long id);

}
