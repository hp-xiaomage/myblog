package com.my.blog.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.blog.website.modal.Vo.ArticleVoExample;
import com.my.blog.website.modal.Vo.ArticleVo;
import com.my.blog.website.modal.Vo.ContentVo;
import com.my.blog.website.modal.Vo.ContentVoExample;
import com.my.blog.website.service.IArticleService;
import com.my.blog.website.dao.ArticleVoMapper;
import com.my.blog.website.dao.ContentVoMapper;
import com.my.blog.website.dto.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BlueT on 2017/3/18.
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class);
    @Resource
    private ArticleVoMapper articleDao;
    @Resource
    private ArticleVoMapper ArticleVoMapper;

    @Override
    public void deleteById(Integer cid, Integer mid) {
        ArticleVoExample ArticleVoExample = new ArticleVoExample();
        ArticleVoExample.Criteria criteria = ArticleVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        ArticleVoMapper.deleteByExample(ArticleVoExample);
    }

    @Override
    public List<ArticleVo> getArticleById(Integer cid, Integer mid) {
        ArticleVoExample ArticleVoExample = new ArticleVoExample();
        ArticleVoExample.Criteria criteria = ArticleVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        return ArticleVoMapper.selectByExample(ArticleVoExample);
    }

    @Override
    public void insertVo(ArticleVo ArticleVo) {
        ArticleVoMapper.insert(ArticleVo);
    }

    @Override
    public Long countById(Integer cid, Integer mid) {
        LOGGER.debug("Enter countById method:cid={},mid={}",cid,mid);
        ArticleVoExample ArticleVoExample = new ArticleVoExample();
        ArticleVoExample.Criteria criteria = ArticleVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        long num = ArticleVoMapper.countByExample(ArticleVoExample);
        LOGGER.debug("Exit countById method return num={}",num);
        return num;
    }
    

    @Override
    public PageInfo<ArticleVo> getArticles(String keyword, Integer page, Integer limit) {
    	System.out.println("mxz--->开始查询数据");
        PageHelper.startPage(page, limit);
        ArticleVoExample articleVoExample = new ArticleVoExample();
        ArticleVoExample.Criteria criteria = articleVoExample.createCriteria();
        criteria.andTitleLike("%" + keyword + "%");
        articleVoExample.setOrderByClause("created desc");
        List<ArticleVo> contentVos = articleDao.selectByExample(articleVoExample);
        return new PageInfo<>(contentVos);
    }

}
