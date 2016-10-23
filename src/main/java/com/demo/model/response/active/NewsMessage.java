package com.demo.model.response.active;

import java.util.List;

public class NewsMessage extends BaseMessage {
	// 多条图文消息信息，默认第一个item为大图
	private List<Article> articles;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
}