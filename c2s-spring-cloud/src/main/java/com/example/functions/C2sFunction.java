package com.example.functions;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.example.domain.C2sRequest;
import com.example.domain.C2sResponse;

public abstract class C2sFunction <T extends C2sRequest, R extends C2sResponse> implements Function<T, R> {

	@Autowired
	protected MessageSource messageSource;
	
	protected String getMessage(final String code, Object...errorArgs) {
		return this.messageSource.getMessage(code, errorArgs, LocaleContextHolder.getLocale());
	}
	
}
