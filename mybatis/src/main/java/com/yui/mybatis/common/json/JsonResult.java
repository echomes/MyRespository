package com.yui.mybatis.common.json;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * $.ajax后需要接受的JSON（个人习惯）
 * AjaxJson 系统自带
 */
@JsonPropertyOrder({ "result", "message", "code" })
public class JsonResult {
	public static final int NOT_LOGIN = -1;
	public static final int CODE_ERROR = 0;
	public static final int CODE_SUCCESS = 1;
	/** 请求结果，0为失败，1为成功 */
	private int result;
	/** 请求结果信息 */
	private String message;
	/**错误码*/
	private Integer code;
	/** 请求的返回数据对象，也将被转为json格式 */
	private Object data;

	public JsonResult() {
	}
	public JsonResult(String message,int result) {
		this.result = result;
		this.message = message;
	}

	public JsonResult(int result, String message) {
		this.result = result;
		this.message = message;
	}

	public JsonResult(int result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public JsonResult(int result, String message, Integer code, Object data) {
		this.result = result;
		this.message = message;
		this.code = code;
		this.data = data;
	}

	public JsonResult setCode1(Integer code){
		setCode(code);return this;
	}
	public JsonResult setData1(Object data){
		setData(data);return this;
	}
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
