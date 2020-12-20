package com.aaron.service.impl;

import com.aaron.dao.SystemLogMapper;
import com.aaron.pojo.SystemLog;
import com.aaron.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/5
 */

@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public int deleteSystemLog(String id) {

        return systemLogMapper.deleteByPrimaryKey(id);
    }

    @Override

    public int insert(SystemLog record) {

        return systemLogMapper.insertSelective(record);
    }

    @Override
    public SystemLog selectSystemLog(String id) {

        return systemLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateSystemLog(SystemLog record) {

        return systemLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertTest(SystemLog record) {

        return systemLogMapper.insert(record);
    }

}
