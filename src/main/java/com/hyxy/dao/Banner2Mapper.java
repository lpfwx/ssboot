package com.hyxy.dao;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.hyxy.entity.Banner2;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface Banner2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner2 record);

    Banner2 selectByPrimaryKey(Integer id);

    List<Banner2> selectAll(@Param(value="begin") int begin,@Param(value="number")int number);

    int updateByPrimaryKey(Banner2 record);
    
    int selectCount();
}