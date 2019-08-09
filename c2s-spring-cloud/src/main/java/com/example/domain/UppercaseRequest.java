package com.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class UppercaseRequest extends C2sRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2129779761477877676L;
	
	// 输入的数据
	private String input;
	private String test;

}
