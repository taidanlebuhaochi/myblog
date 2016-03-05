package com.houmingjian.blog.mapper;

import com.houmingjian.blog.domain.BlogTimeLine;

public interface BlogTimeLineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogTimeLine record);

    int insertSelective(BlogTimeLine record);

    BlogTimeLine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogTimeLine record);

    int updateByPrimaryKeyWithBLOBs(BlogTimeLine record);

    int updateByPrimaryKey(BlogTimeLine record);
}