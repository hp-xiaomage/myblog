package com.my.blog.website.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.blog.website.modal.Vo.ArticleVoExample;
import com.my.blog.website.modal.Vo.ArticleVo;
import com.my.blog.website.modal.Vo.ContentVo;
import com.my.blog.website.modal.Vo.ContentVoExample;
import com.my.blog.website.service.IArticleService;
import com.my.blog.website.utils.DateKit;
import com.my.blog.website.utils.L;
import com.my.blog.website.utils.TaleUtils;
import com.my.blog.website.utils.Tools;
import com.my.blog.website.constant.WebConst;
import com.my.blog.website.dao.ArticleVoMapper;
import com.my.blog.website.dao.ContentVoMapper;
import com.my.blog.website.dto.Types;
import com.my.blog.website.exception.TipException;
import com.vdurmont.emoji.EmojiParser;

import org.apache.commons.lang3.StringUtils;
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
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ArticleServiceImpl.class);
	@Resource
	private ArticleVoMapper articleDao;
	@Resource
	private ArticleVoMapper ArticleVoMapper;

	
	 @Override
	    public void publish(ArticleVo contents) {
	        if (null == contents) {
	            throw new TipException("内容对象为空");
	        }
	        if (StringUtils.isBlank(contents.getTitle())) {
	            throw new TipException("内容标题不能为空");
	        }
	        if (StringUtils.isBlank(contents.getUrl())) {
	            throw new TipException("内容地址不能为空");
	        }
	        int titleLength = contents.getTitle().length();
	        if (titleLength > WebConst.MAX_TITLE_COUNT) {
	            throw new TipException("内容标题过长");
	        }
	        int contentLength = contents.getUrl().length();
	        if (contentLength > WebConst.MAX_TEXT_COUNT) {
	            throw new TipException("内容地址过长");
	        }
	        if (null == contents.getAuthorId()) {
	            throw new TipException("请登录后发布内容");
	        }
	        

	        int time = DateKit.getCurrentUnixTime();
	        contents.setCreated(time);
	        contents.setModified(time);

	        L.i("保存内容："+contents.toString());
	        articleDao.insert(contents);

	    }
	 
	 
	@Override
	public void deleteByCid(Integer cid) {
		ArticleVoExample ArticleVoExample = new ArticleVoExample();
		ArticleVoExample.Criteria criteria = ArticleVoExample.createCriteria();
		if (cid != null) {
			criteria.andCidEqualTo(cid);
		}
		ArticleVoMapper.deleteByExample(ArticleVoExample);

	}

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
		LOGGER.debug("Enter countById method:cid={},mid={}", cid, mid);
		ArticleVoExample ArticleVoExample = new ArticleVoExample();
		ArticleVoExample.Criteria criteria = ArticleVoExample.createCriteria();
		if (cid != null) {
			criteria.andCidEqualTo(cid);
		}
		if (mid != null) {
			criteria.andMidEqualTo(mid);
		}
		long num = ArticleVoMapper.countByExample(ArticleVoExample);
		LOGGER.debug("Exit countById method return num={}", num);
		return num;
	}

	@Override
	public PageInfo<ArticleVo> getArticles(String keyword, Integer page,
			Integer limit) {
		System.out.println("mxz--->开始搜索数据");
		PageHelper.startPage(page, limit);
		ArticleVoExample articleVoExample = new ArticleVoExample();
		ArticleVoExample.Criteria criteria = articleVoExample.createCriteria();
		criteria.andTitleLike("%" + keyword + "%");
		articleVoExample.setOrderByClause("created desc");
		List<ArticleVo> contentVos = articleDao
				.selectByExample(articleVoExample);
		return new PageInfo<>(contentVos);
	}

	@Override
	public PageInfo<ArticleVo> getArticles(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		System.out.println("mxz--->开始查询所有数据");
		PageHelper.startPage(page, limit);
		ArticleVoExample articleVoExample = new ArticleVoExample();
		articleVoExample.setOrderByClause("created desc");
		List<ArticleVo> contentVos = articleDao.selectAll(articleVoExample);
		return new PageInfo<>(contentVos);
	}

	@Override
	public ArticleVo getContents(String id) {
		if (StringUtils.isNotBlank(id)) {
			if (Tools.isNumber(id)) {
				ArticleVo contentVo = articleDao.selectByPrimaryKey(Integer
						.valueOf(id));
				
				return contentVo;
			} else {
				
					throw new TipException(
							"query content by id and return is not one");
			}
		}
		return null;
	}

	

}
