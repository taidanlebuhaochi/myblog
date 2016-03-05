package com.houmingjian.blog.mapper;

import com.houmingjian.blog.domain.BlogPaper;

public interface BlogPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogPaper record);

    int insertSelective(BlogPaper record);

    BlogPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogPaper record);

    int updateByPrimaryKeyWithBLOBs(BlogPaper record);

    int updateByPrimaryKey(BlogPaper record);
}