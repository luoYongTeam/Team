package org.demo.utils;

import java.util.UUID;

public class UUIDUtil {

	//随机产生一个UUID
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
}
