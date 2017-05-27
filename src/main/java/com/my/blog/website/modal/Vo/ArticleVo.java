package com.my.blog.website.modal.Vo;

import java.io.Serializable;

/**
 * @author 
 */
public class ArticleVo implements Serializable {
    /**
     * 项目主键
     */
    private Integer cid;

    private String title;
    private String url;
    private String images;
    
    private Integer created;
    private Integer modified;
    private Integer authorId;
    private String tags;
    private String categories;

    private static final long serialVersionUID = 1L;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Integer getCreated() {
		return created;
	}

	public void setCreated(Integer created) {
		this.created = created;
	}

	public Integer getModified() {
		return modified;
	}

	public void setModified(Integer modified) {
		this.modified = modified;
	}

	
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "ArticleVo [cid=" + cid + ", title=" + title + ", url=" + url
				+ ", images=" + images + ", created=" + created + ", modified="
				+ modified + ", authorId=" + authorId + ", tags=" + tags
				+ ", categories=" + categories + "]";
	}

	
    
}