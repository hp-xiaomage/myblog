package com.my.blog.website.dao;

import com.my.blog.website.modal.Vo.ArticleVo;
import com.my.blog.website.modal.Vo.ArticleVoExample;
import com.my.blog.website.modal.Vo.ArticleVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface ArticleVoMapper {
    long countByExample(ArticleVoExample example);

    int deleteByExample(ArticleVoExample example);

    int deleteByPrimaryKey(ArticleVo key);

    int insert(ArticleVo record);

    int insertSelective(ArticleVo record);

    List<ArticleVo> selectByExample(ArticleVoExample example);

    int updateByExampleSelective(@Param("record") ArticleVo record, @Param("example") ArticleVoExample example);

    int updateByExample(@Param("record") ArticleVo record, @Param("example") ArticleVoExample example);
}