package com.demo.model.response.active;
public class Article {
	// ͼ����Ϣ����
	private String title;
	// ͼ����Ϣ����
	private String description;
	// ͼƬ���ӣ�֧��JPG��PNG��ʽ���Ϻõ�Ч��Ϊ��ͼ360*200��Сͼ200*200
	private String picurl;
	// ���ͼ����Ϣ��ת����
	private String url;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}



}