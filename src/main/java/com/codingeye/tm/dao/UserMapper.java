package com.codingeye.tm.dao;

import com.codingeye.tm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Camon on 2017/6/26.
 */

@Mapper
public interface UserMapper {

    User selectUserBySignIn(@Param("username") String username,
                            @Param("password") String password);

    void insertUserBySignUp(@Param("username") String username,
                            @Param("password") String password);

    void updateUserType(@Param("username") String username,
                        @Param("type") String type);

    User getUserType(@Param("username") String username);
}
