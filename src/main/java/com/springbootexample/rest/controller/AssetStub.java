package com.springbootexample.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.springbootexample.rest.model.Asset;

public class AssetStub {
	private static Map<Long, Asset> assets = new HashMap<Long, Asset>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		Asset a = new Asset(1L, "Mobile", "Communication", "New");
		assets.put(1L, a);
		Asset b = new Asset(2L, "TV", "Watching", "Old");
		assets.put(2L, b);
		Asset c = new Asset(3L, "Fridge", "Storing", "Older");
		assets.put(3L, c);
	}

	public static List<Asset> list() {
		return new ArrayList<Asset>(assets.values());
	}

	public static Asset create(Asset asset) {
		idIndex += idIndex;
		asset.setId(idIndex);
		assets.put(idIndex, asset);
		return asset;
	}

	public static Asset get(Long id) {
		return assets.get(id);
	}

	public static Asset update(Long id, Asset asset) {
		assets.put(id, asset);
		return asset;
	}

	public static Asset delete(Long id) {
		return assets.remove(id);
	}
}
