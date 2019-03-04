package com.legend.analysis.mapper;

public interface TemplateTableMapper {
    int deleteByPrimaryKey(String id);

    int insert(TemplateTable record);

    int insertSelective(TemplateTable record);

    TemplateTable selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TemplateTable record);

    int updateByPrimaryKey(TemplateTable record);
}