package com.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class UppercaseResponse extends C2sResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4630169989922963357L;
	
	// 返回的结果
	private String result;

}
