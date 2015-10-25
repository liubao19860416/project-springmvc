package com.saick.base.service.api;

import java.util.List;
import java.util.Map;

/**
 * dwr的服务接口
 * 
 * @author Thinkpad
 * 
 */
public interface DwrService {
    // 测试方法1
    public String testdwr() throws Exception;
    
    // 测试方法1
    public String testdwr2(String name) throws Exception;

    // 获取近几年记录
    public List<Map<String, String>> showDwrYears() throws Exception;
}
