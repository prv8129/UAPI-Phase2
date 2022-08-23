package com.zee.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zee.ro.FavoriteRO;

public class FavoriteUtil {
	public static List<FavoriteRO> getAllFavoritesData(boolean returnSingleObject) {
		FavoriteRO favoriteRO1 = new FavoriteRO();
		favoriteRO1.setUserId("1134dnnnd");
		favoriteRO1.setId("asdasd");
		favoriteRO1.setAssetId("1212");
		favoriteRO1.setAssetType(12);
		favoriteRO1.setDate(new Date());

		FavoriteRO favoriteRO2 = new FavoriteRO();
		favoriteRO2.setUserId("1134dnnnd");
		favoriteRO2.setId("234esf");
		favoriteRO2.setAssetId("1212");
		favoriteRO2.setAssetType(12);
		favoriteRO2.setDate(new Date());

		List<FavoriteRO> list = new ArrayList<FavoriteRO>();
		list.add(favoriteRO1);
		if (!returnSingleObject) {
			list.add(favoriteRO2);
		}
		return list;
	}
	
	public static FavoriteRO createOrUpdateFavorite(FavoriteRO entity) {
		FavoriteRO favoriteRO2 = new FavoriteRO();
		favoriteRO2.setUserId(entity.getUserId());
		favoriteRO2.setId("234esf");
		favoriteRO2.setAssetId(entity.getAssetId());
		favoriteRO2.setAssetType(entity.getAssetType());
		favoriteRO2.setDate(entity.getDate());
		return favoriteRO2;
	}
}
