package com.houmingjian.android.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CityUtil {
	public static String getProvince(String name){
		String path = "../../city_data/"+ name +".txt";
		File file = new File(CityUtil.class.getClassLoader().getResource(path).getPath());
		
		StringBuilder sb = new StringBuilder();
		try {
			InputStream in = new FileInputStream(file);
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "utf-8"));
			String line = null;
			try {
				while ( (line = bufferedReader.readLine()) != null){
					sb.append(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
}
