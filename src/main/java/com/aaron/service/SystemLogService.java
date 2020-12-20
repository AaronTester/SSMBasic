package com.aaron.service;

import com.aaron.pojo.SystemLog;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/5
 */
public interface SystemLogService {

    int deleteSystemLog(String id);

    int insert(SystemLog record);

    int insertTest(SystemLog record);

    SystemLog selectSystemLog(String id);

    int updateSystemLog(SystemLog record);
}