package com.codingeye.tm.dao;

import com.codingeye.tm.pojo.DailyActivity;
import com.codingeye.tm.pojo.MonthlyActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * Created by Camon on 2017/6/10.
 */
@Mapper
public interface ActivityMapper {

    DailyActivity selectByUserAndDate(@Param("username") String username,
                                      @Param("active_date") String active_date);

    MonthlyActivity selectByUserAndMonth(@Param("username") String username,
                                         @Param("yearMonth") String yearMonth);

    void insertByUserAndDate(@Param("activity") DailyActivity activity);

    void updateByUserAndDate(@Param("activity") DailyActivity activity);
}
