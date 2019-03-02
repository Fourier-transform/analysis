package com.legend.analysis.mapper;

public interface LogMapper {
    int insert(Log record);

    int insertSelective(Log record);
}