package com.codingeye.tm.dao;

import com.codingeye.tm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Camon on 2017/6/25.
 */
@Mapper
public interface RecommendMapper {

    List<User> getSameTypeUsers(@Param("type") String type);
}
