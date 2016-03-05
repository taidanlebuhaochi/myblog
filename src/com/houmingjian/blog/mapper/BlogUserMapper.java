package com.houmingjian.blog.mapper;

import com.houmingjian.blog.domain.BlogUser;

public interface BlogUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}