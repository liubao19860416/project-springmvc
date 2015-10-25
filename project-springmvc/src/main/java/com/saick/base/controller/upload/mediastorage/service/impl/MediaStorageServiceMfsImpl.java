package com.saick.base.controller.upload.mediastorage.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.FileCopyUtils;

import com.saick.base.controller.upload.mediastorage.exception.MediaStorageFailException;
import com.saick.base.controller.upload.mediastorage.service.MediaStorageTypeEnum;
import com.saick.base.controller.upload.mediastorage.util.FileUtil;
import com.saick.base.controller.upload.mediastorage.util.Md5Util;
import com.saick.base.controller.upload.mediastorage.util.TimeUtil;

/**
 * FileStorageService实现类.内部按照MFS存储.
 * 
 * @author jinhuibin
 *
 */
public class MediaStorageServiceMfsImpl extends AbstractMediaStorageService implements InitializingBean {

	private Logger logger = LoggerFactory.getLogger(MediaStorageServiceMfsImpl.class);
	
	//gagu.ucm.projectCode
	private String projectCode;
	private int useProjectDir;
	private String mfsPath;
	private String publicPath;
	private String privacyPath;

	
	/**MFS文件下的存储目录，需要通过API拼接返回*/
	private String fileDir;
	/**MFS公有文件完整的存储目录*/
	private String storagePublicPath;
	/**MFS私有文件完整的存储目录*/
	private String storagePrivacyPath; 
	
	@Override
	protected String doStorage(InputStream inputStream,String dirPrefix, String picType,
			MediaStorageTypeEnum storageType) throws FileNotFoundException,IOException, MediaStorageFailException {
		
		String subDir= FileUtil.buildPath(fileDir,dirPrefix,TimeUtil.time2YYYYMMDD(new Date()));
		
		String fullDir = FileUtil.buildPath( getStoragePath(storageType),subDir);
		FileUtil.mkdir(fullDir);
		
		String fileName = getFileName(picType);
		
		String fullPath = FileUtil.buildPath( fullDir,fileName);
		
		File destFile = new File(fullPath);
		try {
			FileCopyUtils.copy(inputStream,new BufferedOutputStream(new FileOutputStream(destFile)) );
			logger.debug("storage file {} success",fullPath);
		} catch (FileNotFoundException e) {
			logger.error("storage file not found : {} {}",fullPath,e.getMessage());
			throw e;
		} catch (IOException e) {
			logger.error("storage file exception : {} {}",fullPath,e.getMessage());
			throw e;
		}
		return FileUtil.buildPath(subDir,fileName);
	}
	
	@Override
	protected boolean doUpdateFile(String filePath,InputStream inputStream,MediaStorageTypeEnum storageType) throws FileNotFoundException, IOException {
		File destFile = new File(FileUtil.buildPath( getStoragePath(storageType),filePath));
		try {
			FileCopyUtils.copy(inputStream,new BufferedOutputStream(new FileOutputStream(destFile)) );
			logger.debug("update file {} success",filePath);
			return true;
		} catch (FileNotFoundException e) {
			logger.error("update file not found : {} {}",destFile.getAbsolutePath(),e.getMessage());
			throw e;
		} catch (IOException e) {
			logger.error("update file exception : {} {}",destFile.getAbsolutePath(),e.getMessage());
			throw e;
		}
	}
	
	@Override
	protected byte[] doRead(String filePath, MediaStorageTypeEnum storageType) throws IOException {
		File destFile = new File(FileUtil.buildPath( getStoragePath(storageType),filePath));
		byte[] bytes;
		try {
			bytes = FileCopyUtils.copyToByteArray(destFile);
			logger.debug("read file {} success",destFile.getAbsolutePath());
		} catch (IOException e) {
			logger.error("read file exception : {} {}",destFile.getAbsolutePath(),e.getMessage());
			throw e;
		}
		return bytes;
	}
	
	
	@Override
	protected boolean doDelete(String filePath ,MediaStorageTypeEnum storageType) throws FileNotFoundException,IOException{
		File destFile = new File(FileUtil.buildPath( getStoragePath(storageType),filePath));
		if(!destFile.exists()){
			throw new FileNotFoundException();
		}else{
			if(destFile.isDirectory()){
				throw new IOException(filePath+" is directory");
			}else{
				logger.debug("delete file {} success",destFile.getAbsolutePath());
				return destFile.delete();
			}
		}
	}
	
	@Override
	protected long doFileLastmodifytime(String path, MediaStorageTypeEnum storageType) throws IOException {
		File destFile = new File(FileUtil.buildPath( getStoragePath(storageType),path));
		if(!destFile.exists()){
			throw new FileNotFoundException();
		}
		return destFile.lastModified();
	}
	
	
	private String getFileName(String picType){
		return UUID.randomUUID().toString().replaceAll("\\-", "")+(!StringUtils.isEmpty(picType)?"."+picType.toLowerCase():"");
	}
	
	private String getStoragePath(MediaStorageTypeEnum storageType){
		String path = storagePrivacyPath;
		if(storageType == MediaStorageTypeEnum.PUBLIC){
			path = storagePublicPath;
		}else if (storageType == MediaStorageTypeEnum.PRIVACY){
			path = storagePrivacyPath;
		}
		return path;
	}
	
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		logger.info("projectCode {}",projectCode);
		logger.info("useProjectDir {}",useProjectDir);
		logger.info("mfsPath {}",mfsPath);
		logger.info("publicPath {}",publicPath);
		logger.info("privacyPath {}",privacyPath);
		
		if(useProjectDir!=1 || StringUtils.isEmpty(projectCode)){
			fileDir = Md5Util.md5_16("default",true);
		}else{
			fileDir = Md5Util.md5_16(projectCode, true);
		}	
				
		storagePublicPath = FileUtil.buildPath(mfsPath , publicPath) ;
		storagePrivacyPath = FileUtil.buildPath(mfsPath , privacyPath);
		
		FileUtil.mkdir(FileUtil.buildPath(storagePublicPath,fileDir));
		FileUtil.mkdir(FileUtil.buildPath(storagePrivacyPath,fileDir));
		
		logger.info("prepare storagePublicPath : {}",storagePublicPath);
		logger.info("prepare storagePrivacyPath : {}",storagePrivacyPath);
	}
	

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public void setUseProjectDir(int useProjectDir) {
		this.useProjectDir = useProjectDir;
	}
	public void setMfsPath(String mfsPath) {
		this.mfsPath = mfsPath;
	}
	public void setPublicPath(String publicPath) {
		this.publicPath = publicPath;
	}
	public void setPrivacyPath(String privacyPath) {
		this.privacyPath = privacyPath;
	}

}
