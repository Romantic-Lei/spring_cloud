package com.example.functions;

import org.springframework.stereotype.Component;

import com.example.contants.LambdaConstant;
import com.example.domain.UppercaseRequest;
import com.example.domain.UppercaseResponse;
import com.example.service.UppercaseService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("uppercaseFunction")
public class UppercaseFunction extends C2sFunction<UppercaseRequest, UppercaseResponse> {
	
//	private static Logger log = LoggerFactory.getLogger(UppercaseFunction.class);
	
	private final UppercaseService uppercaseService;
	
	// 初始化 uppercaseService
	public UppercaseFunction(final UppercaseService uppercaseService) {
		super();
		this.uppercaseService = uppercaseService;
	}

	@Override
	public UppercaseResponse apply(final UppercaseRequest uppercaseRequest) {
		// 開始ログ
		String startMsg = this.getMessage(LambdaConstant.MSG.C2S_MSG_COM_001I, uppercaseRequest.toString());
		log.info(startMsg);
		
		final UppercaseResponse uppercaseResponse = new UppercaseResponse();
		// 当取不到输入值时，我们抛出异常
		if(uppercaseRequest.getTest() == null) {
			uppercaseResponse.setErrorCode(LambdaConstant.MSG.C2S_MSG_COM_004E);
			uppercaseResponse.setStatusCode(1);
		}else {
			uppercaseResponse.setStatusCode(0);
			uppercaseResponse.setData("OK");
		}
		
		
//		final UppercaseResponse result = new UppercaseResponse();
//		result.setResult(uppercaseService.uppercase(uppercaseRequest.getInput()));
		uppercaseResponse.setResult(uppercaseService.uppercase(uppercaseRequest.getInput()));
		
		// 終了ログ
		String endMsg = this.getMessage(LambdaConstant.MSG.C2S_MSG_COM_002I, uppercaseResponse.toString());
		log.info(endMsg);
//		int i = 5/0;
//		System.out.println("求和");
		return uppercaseResponse;
	}
	
}
