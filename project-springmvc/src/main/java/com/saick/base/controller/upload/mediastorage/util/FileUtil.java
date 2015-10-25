package com.saick.base.controller.upload.mediastorage.util;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import com.saick.base.controller.upload.mediastorage.exception.MediaStorageFailException;


public class FileUtil {
	
	public final static String FILE_SPLIT = "/";

	public static String stripLastSplash(String string){
		if (StringUtils.isEmpty(string) ){
			return "";
		}
		string = string.trim();
		return string.substring(string.length()-1, string.length()).equals(FILE_SPLIT)?string.substring(0,string.length()-1):string;
	}
	
	public static String stripFirstSplash(String string){
		if (StringUtils.isEmpty(string) ){
			return "";
		}
		string = string.trim();
		return string.substring(0, 1).equals(FILE_SPLIT)?string.substring(1):string;
	}
	
	public static String stripSplash(String string){
		return stripFirstSplash(stripLastSplash(string));
	}
	
	public static void mkdir(String path) throws MediaStorageFailException{
		File f = new File(path);
		if(!f.exists()){
			if(!f.mkdirs()){
				throw new MediaStorageFailException("create folder error "+path);
			}
		}
	}
	
	public static String buildPath(String ...strings){
		StringBuilder builder = new StringBuilder();
		for (String string : strings) {
			if(StringUtils.isNotEmpty(string)){
				builder.append(FILE_SPLIT).append(stripSplash(string));	
			}
		}
		return builder.toString();
	}
}
