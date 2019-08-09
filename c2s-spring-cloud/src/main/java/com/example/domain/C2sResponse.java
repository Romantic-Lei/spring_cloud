package com.example.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * 共通 Response 
 *
 */
@Data
public class C2sResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6636535513798246987L;
	
	// 返回的状态码
	private Integer statusCode;
	
	// 错误码
	private String errorCode;
	
	// 返回的处理结果状态
	private String data;

}
