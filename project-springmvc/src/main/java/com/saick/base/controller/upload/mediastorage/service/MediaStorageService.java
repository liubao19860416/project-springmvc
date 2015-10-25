package com.saick.base.controller.upload.mediastorage.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.saick.base.controller.upload.mediastorage.exception.MediaStorageFailException;


/**
 * 文件存储服务.
 * 
 * 提供文件存储,脚本类文件不能存放（例如js,asp,aspx,php,jsp, py等）.
 * 
 * @see FileStorageTypeEnum
 * @see ByteArrayInputStream
 * @author jinhuibin
 *
 */
public interface MediaStorageService {

	/**
	 * 存储图片,最大限制10M.可以通过Nginx访问到。
	 * 目录 /mfs/public/storage/
	 * 
	 * @param picInputStream 图片流.API会对inputstream做关闭
	 * @param picType 图片类型，［a-z\d]{1-10}
	 * @return
	 * 存储路径 
	 * @throws MediaStorageFailException 
	 */
	public String storagePicture(InputStream picInputStream,String picType) throws MediaStorageFailException;
	
	/**
	 * 删除图片
	 * @param path 图片路径
	 * @return
	 * 返回是否删除成功
	 * @throws MediaStorageFailException
	 */
	public boolean deletePicture(String path) throws MediaStorageFailException;
	
	/**
	 * 存储文件,最大限制10M,只能通过API访问到.
	 * 目录 /mfs/privacy/storage/
	 * 
	 * @param fileInputStream 文件流.API会对inputstream做关闭
	 * @return
	 * 存储路径
	 * @throws MediaStorageFailException 
	 */
	public String storageFile(InputStream fileInputStream) throws MediaStorageFailException;
	
	/**
	 * 存储文件，最大限制10M，只能通过API访问到，添加目录规则
	 * 目录 /mfs/privacy/storage/dirPrefix
	 * @param fileInputStream 文件流，API会对inputstream做关闭
	 * @param dirPrefix
	 * 存储目录前缀 ［a-z\d]{1-20}
	 * @return
	 * 存储路径
	 * @throws MediaStorageFailException
	 */
	public String storageFile(InputStream fileInputStream,String dirPrefix) throws MediaStorageFailException;
	
	/**
	 * 更新文件，最大限制10M，只能通过API访问到，添加目录规则
	 * 目录 /mfs/privacy/storage/dirPrefix
	 * @param path
	 * 文件存储路径
	 * @param fileInputStream
	 *  文件流，API会对inputstream做关闭
	 * @return
	 * 是否更新成功
	 * @throws MediaStorageFailException
	 */
	public boolean updateFile(String path, InputStream fileInputStream) throws MediaStorageFailException;
	
	/**
	 * 删除文件
	 * @param path
	 * 文件路径
	 * @return
	 * 是否删除成功
	 * @throws MediaStorageFailException
	 */
	public boolean deleteFile(String path) throws MediaStorageFailException;
	
	/**
	 * 按照存储路径获取.
	 * 目录 /mfs/privacy/storage/
	 * 
	 * @param path
	 * 存储文件接口返回的存储路径
	 * @return
	 * 文件字节流
	 * @throws MediaStorageFailException 
	 * 
	 * @see MediaStorageService.storageFile
	 */
	public byte[] readFile(String path) throws MediaStorageFailException;
	
	/**
	 * 按照存储目录获得文件的最后一次修改时间
	 * @param path
	 * @return
	 * @throws MediaStorageFailException
	 * 
	 * @see
	 * File.lastModified()
	 */
	public long fileLastmodifytime(String path) throws MediaStorageFailException;
}
