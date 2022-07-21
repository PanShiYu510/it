package com.example.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.it.enity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
