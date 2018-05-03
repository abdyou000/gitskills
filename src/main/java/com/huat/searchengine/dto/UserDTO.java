package com.huat.searchengine.dto;

import com.huat.searchengine.entity.TblUser;

public class UserDTO extends TblUser {
	
	private String verifyNo;

	public String getVerifyNo() {
		return verifyNo;
	}

	public void setVerifyNo(String verifyNo) {
		this.verifyNo = verifyNo;
	}

	@Override
	public String toString() {
		 
		return super.toString() + "UserDTO [verifyNo=" + verifyNo + "]";
	}
	
	
}
