package com.codingeye.tm.dao;

import com.codingeye.tm.pojo.Activity;
import com.codingeye.tm.pojo.ReportActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * Created by Camon on 2017/6/10.
 */
@Mapper
public interface ActivityMapper {

    Activity selectByUserAndDate(@Param("username") String username,
                                 @Param("active_date") String active_date);

    ReportActivity selectByUserAndMonth(@Param("username") String username,
                                        @Param("yearMonth") String yearMonth);
}
