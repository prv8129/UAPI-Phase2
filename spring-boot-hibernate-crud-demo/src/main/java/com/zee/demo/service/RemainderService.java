package com.zee.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.demo.exception.RecordNotFoundException;
import com.zee.demo.repository.FavoriteRepository;
import com.zee.ro.RemainderRO;
import com.zee.util.RemainderUtil;

@Service
public class RemainderService {

	@Autowired
	FavoriteRepository repository;

	public List<RemainderRO> getAllRemainders() {
		// List<FavoriteRO> favoriteList = repository.findAll();
		List<RemainderRO> favoriteList = RemainderUtil.getAllFavoritesData(false);

		if (favoriteList.size() > 0) {
			return favoriteList;
		} else {
			return new ArrayList<RemainderRO>();
		}
	}

	public RemainderRO getRemainderById(Long id) throws RecordNotFoundException {
		RemainderRO favoriteRO2 = RemainderUtil.getAllFavoritesData(true).get(0);
		return favoriteRO2;
	}

	public RemainderRO updateRemainder(RemainderRO entity) throws RecordNotFoundException {
		return RemainderUtil.createOrupdateRemainder(entity);
	}

	public RemainderRO createRemainder(RemainderRO entity) throws RecordNotFoundException {
		return RemainderUtil.createOrupdateRemainder(entity);
	}

	public void deleteRemainderById(Long id) throws RecordNotFoundException {
		// record deleted
	}
}