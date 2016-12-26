package org.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

		public static String toJson(Object obj){
			return new Gson().toJson(obj);
		}

		public static String toJson(Object obj,String date){

			GsonBuilder builder=new GsonBuilder();
			Gson gson=builder.setDateFormat(date).create();
			return gson.toJson(obj);
			
		}
		
			}

