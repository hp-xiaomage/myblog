package com.my.blog.website.service;

import com.github.pagehelper.PageInfo;
import com.my.blog.website.modal.Vo.ArticleVo;
import com.my.blog.website.modal.Vo.ContentVo;

import java.util.List;

/**
 * Created by BlueT on 2017/3/18.
 */
public interface IArticleService {
    /**
     * 按住键删除
     * @param cid
     * @param mid
     */
    void deleteById(Integer cid, Integer mid);

    /**
     * 按主键统计条数
     * @param cid
     * @param mid
     * @return 条数
     */
    Long countById(Integer cid, Integer mid);


    /**
     * 保存對象
     * @param ArticleVo
     */
    void insertVo(ArticleVo ArticleVo);

    /**
     * 根据id搜索
     * @param cid
     * @param mid
     * @return
     */
    List<ArticleVo> getArticleById(Integer cid, Integer mid);
    
    /**
     * 搜索、分页
     * @param keyword keyword
     * @param page page
     * @param limit limit
     * @return ContentVo
     */
    PageInfo<ArticleVo> getArticles(String keyword,Integer page,Integer limit);
    
}
