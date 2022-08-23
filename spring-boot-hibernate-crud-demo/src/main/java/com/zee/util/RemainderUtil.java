package com.zee.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zee.ro.RemainderRO;

public class RemainderUtil {

	public static List<RemainderRO> getAllFavoritesData(boolean returnSingleObject) {
		RemainderRO remainderRO1 = new RemainderRO();
		remainderRO1.setUserId("1134dnnnd");
		remainderRO1.setId("asdasd");
		remainderRO1.setAssetId("1212");
		remainderRO1.setAssetType(12);
		remainderRO1.setDate(new Date());

		RemainderRO remainderRO2 = new RemainderRO();
		remainderRO2.setUserId("1134dnnnd");
		remainderRO2.setId("234esf");
		remainderRO2.setAssetId("1212");
		remainderRO2.setAssetType(12);
		remainderRO2.setDate(new Date());

		List<RemainderRO> list = new ArrayList<RemainderRO>();
		list.add(remainderRO1);
		if (!returnSingleObject) {
			list.add(remainderRO2);
		}
		return list;
	}
	
	public static RemainderRO createOrupdateRemainder(RemainderRO entity) {
		RemainderRO remainderRO2 = new RemainderRO();
		remainderRO2.setUserId(entity.getUserId());
		remainderRO2.setId("234esf");
		remainderRO2.setAssetId(entity.getAssetId());
		remainderRO2.setAssetType(entity.getAssetType());
		remainderRO2.setDate(entity.getDate());
		return remainderRO2;
	}
}
