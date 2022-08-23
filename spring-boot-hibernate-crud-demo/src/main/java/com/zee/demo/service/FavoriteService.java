package com.zee.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.demo.exception.RecordNotFoundException;
import com.zee.demo.repository.FavoriteRepository;
import com.zee.ro.FavoriteRO;
import com.zee.util.FavoriteUtil;

@Service
public class FavoriteService {

	@Autowired
	FavoriteRepository repository;

	public List<FavoriteRO> getAllFavorites() {
		// List<FavoriteRO> favoriteList = repository.findAll();
		List<FavoriteRO> favoriteList = FavoriteUtil.getAllFavoritesData(false);

		if (favoriteList.size() > 0) {
			return favoriteList;
		} else {
			return new ArrayList<FavoriteRO>();
		}
	}

	public FavoriteRO getEmployeeById(Long id) throws RecordNotFoundException {
		FavoriteRO favoriteRO2 = FavoriteUtil.getAllFavoritesData(true).get(0);
		return favoriteRO2;
	}

	public FavoriteRO updateEmployee(FavoriteRO entity) throws RecordNotFoundException {
		return FavoriteUtil.createOrUpdateFavorite(entity);
	}

	public FavoriteRO createEmployee(FavoriteRO entity) throws RecordNotFoundException {
		return FavoriteUtil.createOrUpdateFavorite(entity);
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		// record deleted
	}
}