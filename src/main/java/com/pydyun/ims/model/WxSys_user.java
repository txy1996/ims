package com.pydyun.ims.model;

public class WxSys_user {
//	private Integer id;  //用后id
    private String username;  //用户名
    private String head;  //头像
public WxSys_user(String username, String head) {
	super();
	this.username = username;
	this.head = head;
}
public WxSys_user() {
	super();
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getHead() {
	return head;
}
public void setHead(String head) {
	this.head = head;
}
@Override
public String toString() {
	return "WxSys_user [username=" + username + ", head=" + head + "]";
}

}
