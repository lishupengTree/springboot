package com.demo.model.request;
public class VideoMessage extends BaseMessage {
	// ��Ƶ��Ϣý��ID
	private String MediaId;
	// ��Ƶ��Ϣ����ͼ��ý��id
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}


}