package com.demo.model.request;
public class LocationMessage2 {
	// ������΢�ź�
	private String ToUserName;
	// ���ͷ��ʺţ�һ��OpenID��
	private String FromUserName;
	// ��Ϣ����ʱ�� �����ͣ�
	private long CreateTime;
	// ��Ϣ����
	private String MsgType;
	// �¼�����
	private String Event;
	// ����λ��ά��
	private String Latitude;
	// ����λ�þ���
	private String Longitude;
	// ����λ�þ���
	private String Precision;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getPrecision() {
		return Precision;
	}
	public void setPrecision(String precision) {
		Precision = precision;
	}
}