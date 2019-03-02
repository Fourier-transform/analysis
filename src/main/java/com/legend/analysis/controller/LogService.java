package com.legend.analysis.controller;

import com.legend.analysis.mapper.Log;
import com.legend.analysis.mapper.LogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogService  {

    @Resource
    private LogMapper logMapper;

    public void insert(Log record) {
        logMapper.insert(record);
    }

    public int insertSelective(Log record) {
        return 0;
    }
}
