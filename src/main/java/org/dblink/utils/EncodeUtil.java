package org.dblink.utils;

/**
 *
 *@author huangyijie
 *
 */
public class EncodeUtil {

	public static String encodeSpace(String url) {
		return url.replaceAll(" ","%20");
	}
}
