package com.jihyun.myboard.mapper;

import com.jihyun.myboard.entity.Join;
import com.jihyun.myboard.entity.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JoinMapper {
    public void insertJoin(String username, String password);
}
