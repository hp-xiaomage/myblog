package com.my.blog.website.service;

import com.github.pagehelper.PageInfo;
import com.my.blog.website.modal.Vo.ArticleVo;
import com.my.blog.website.modal.Vo.ArticleVoExample;
import com.my.blog.website.modal.Vo.ContentVo;
import com.my.blog.website.modal.Vo.ContentVoExample;

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
    /**
     * mxz 内容归档
     * @param page page
     * @param limit limit
     * @return ContentVo
     */
    PageInfo<ArticleVo> getArticles(Integer page,Integer limit);
    
    /**
     * 根据文章id删除
     * @param cid
     */
    void deleteByCid(Integer cid);
    
    /**
     * 根据id或slug获取文章
     *
     * @param id id
     * @return ContentVo
     */
    ArticleVo getContents(String id);
    
    /**
     * 发布文章
     * @param contents
     */
    void publish(ArticleVo contents);
}
