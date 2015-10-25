package com.saick.base.controller.upload.mediastorage.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.saick.base.controller.upload.mediastorage.exception.MediaStorageFailException;
import com.saick.base.controller.upload.mediastorage.service.MediaStorageService;
import com.saick.base.controller.upload.mediastorage.service.MediaStorageTypeEnum;


public abstract class AbstractMediaStorageService implements MediaStorageService,InitializingBean{

	private Logger logger = LoggerFactory.getLogger(AbstractMediaStorageService.class);
	
	//^[a-z\\d]{1,20}$
	private String fileDirPrefixRegex;
	//^[a-z\\d]{1,10}$
	private String fileTypeRegex;
	//^js|php|aspx|jsp|asp|py$
	private String fileTypeBlacklistRegex;
	//^.*\\.\\..*$
	private String filePathBlacklistRegex;
	
	public String storagePicture(InputStream picInputStream, String picType) throws MediaStorageFailException {
		return storage(picInputStream,"",picType,MediaStorageTypeEnum.PUBLIC);
	}
	public String storageFile(InputStream fileInputStream) throws MediaStorageFailException {
		return storage(fileInputStream,"","",MediaStorageTypeEnum.PRIVACY);
	}
	public String storageFile(InputStream fileInputStream,String dirPrefix) throws MediaStorageFailException{
		return storage(fileInputStream,dirPrefix,"",MediaStorageTypeEnum.PRIVACY);
	}
	public boolean deletePicture(String path) throws MediaStorageFailException{
		return delete(path,MediaStorageTypeEnum.PUBLIC);
	}
	public boolean deleteFile(String path) throws MediaStorageFailException{
		return delete(path,MediaStorageTypeEnum.PRIVACY);
	}
	public byte[] readFile(String path) throws MediaStorageFailException {
		return read(path,MediaStorageTypeEnum.PRIVACY);
	}
	
	
	protected String storage(InputStream inputStream,String dirPrefix,String picType,MediaStorageTypeEnum storageType) throws MediaStorageFailException{
		try {
			if(StringUtils.isNotEmpty(dirPrefix)){
				dirPrefix = dirPrefix.toLowerCase();
			}
			if(StringUtils.isNotEmpty(picType)){
				picType = picType.toLowerCase();
			}
			if(StringUtils.isNotEmpty(dirPrefix) && !Pattern.matches(fileDirPrefixRegex, dirPrefix)){
				throw new MediaStorageFailException("pic type error");
			}
			if(StringUtils.isNotEmpty(picType) && !Pattern.matches(fileTypeRegex, picType)){
				throw new MediaStorageFailException("pic type error");
			}
			if(StringUtils.isNotEmpty(picType) &&  Pattern.matches(fileTypeBlacklistRegex, picType)){
				throw new MediaStorageFailException("file path error");
			}
			return doStorage(inputStream, dirPrefix,picType, storageType);
		} catch (FileNotFoundException e) {
			logger.error("file not found error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		} catch (IOException e) {
			logger.error("file storage error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		} catch (Exception e){
			logger.error("file storage unknown error",e);
			throw new MediaStorageFailException(e.getMessage());
		}
	}
	
	protected byte[] read(String path,MediaStorageTypeEnum storageType) throws MediaStorageFailException{
		try {
			if(StringUtils.isEmpty(path) || Pattern.matches(filePathBlacklistRegex, path)){
				throw new MediaStorageFailException("file path error");
			}
			return doRead(path,storageType);
		} catch (IOException e) {
			logger.error("file read error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		} catch(MediaStorageFailException e){
			logger.error("file storage error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		}
		catch (Exception e){
			logger.error("file read unknown error",e);
			throw new MediaStorageFailException(e.getMessage());
		}
	}
	
	public boolean updateFile(String path, InputStream fileInputStream) throws MediaStorageFailException{
		try {
			if(StringUtils.isEmpty(path) || Pattern.matches(filePathBlacklistRegex, path)){
				throw new MediaStorageFailException("file path error");
			}
			return doUpdateFile(path,fileInputStream,MediaStorageTypeEnum.PRIVACY);
		} catch (IOException e) {
			logger.error("file read error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		} catch(MediaStorageFailException e){
			logger.error("file storage error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		}
		catch (Exception e){
			logger.error("file read unknown error",e);
			throw new MediaStorageFailException(e.getMessage());
		}
	}
	
	protected boolean delete(String path ,MediaStorageTypeEnum storageType)throws MediaStorageFailException{
		try{
			if(StringUtils.isEmpty(path) || Pattern.matches(filePathBlacklistRegex, path)){
				throw new MediaStorageFailException("file path error");
			}
			return doDelete(path, storageType);
		} catch(FileNotFoundException e){
			return true;
		} catch (IOException e) {
			logger.error("file delete error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		}catch (Exception e){
			logger.error("file delete unknown error",e);
			throw new MediaStorageFailException(e.getMessage());
		}
	}
	
	public long fileLastmodifytime(String path) throws MediaStorageFailException{
		try {
			if(StringUtils.isEmpty(path) || Pattern.matches(filePathBlacklistRegex, path)){
				throw new MediaStorageFailException("file path error");
			}
			return doFileLastmodifytime(path,MediaStorageTypeEnum.PRIVACY);
		} catch (IOException e) {
			logger.error("fileLastmodifytime error {}",e.getMessage());
			throw new MediaStorageFailException(e.getMessage());
		}catch (Exception e){
			logger.error("fileLastmodifytime unknown error",e);
			throw new MediaStorageFailException(e.getMessage());
		}
	}
	
	protected abstract String doStorage(InputStream inputStream,String dirPrefix,String picType,MediaStorageTypeEnum storageType) 
			throws FileNotFoundException, IOException, MediaStorageFailException;

	protected abstract byte[] doRead(String path, MediaStorageTypeEnum storageType) throws IOException ;
	
	protected abstract long doFileLastmodifytime(String path, MediaStorageTypeEnum storageType) throws IOException ;
	
	protected abstract boolean doDelete(String path ,MediaStorageTypeEnum storageType) throws FileNotFoundException, IOException ;
	
	protected abstract boolean doUpdateFile(String path,InputStream inputStream,MediaStorageTypeEnum storageType) throws FileNotFoundException, IOException ;
	
	public void afterPropertiesSet() throws Exception {
		logger.debug("fileTypeRegex {}",fileTypeRegex);
		logger.debug("fileTypeBlacklistRegex {}",fileTypeBlacklistRegex);
		logger.debug("filePathBlacklistRegex {}",filePathBlacklistRegex);
	}
	
	public void setFileTypeRegex(String fileTypeRegex) {
		this.fileTypeRegex = fileTypeRegex;
	}

	public void setFilePathBlacklistRegex(String filePathBlacklistRegex) {
		this.filePathBlacklistRegex = filePathBlacklistRegex;
	}
	public void setFileTypeBlacklistRegex(String fileTypeBlacklistRegex) {
		this.fileTypeBlacklistRegex = fileTypeBlacklistRegex;
	}
	public void setFileDirPrefixRegex(String fileDirPrefixRegex) {
		this.fileDirPrefixRegex = fileDirPrefixRegex;
	}
}
