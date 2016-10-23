package com.demo.model.response.active;
public class VideoMessage extends BaseMessage {
	//发送的视频的媒体
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}


}