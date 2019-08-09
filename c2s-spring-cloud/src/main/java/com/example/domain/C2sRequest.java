package com.example.domain;

import java.io.Serializable;

import lombok.Data;

/**
 * 共通request
 *
 */
@Data
public class C2sRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8973961152091188406L;

	private String functionNmae;
	
	private String AwsRequestId;

}
