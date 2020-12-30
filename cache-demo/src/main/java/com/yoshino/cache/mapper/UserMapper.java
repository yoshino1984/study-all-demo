package com.yoshino.cache.mapper;

import com.yoshino.cache.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User find(int id);

    List<User> list();

}
