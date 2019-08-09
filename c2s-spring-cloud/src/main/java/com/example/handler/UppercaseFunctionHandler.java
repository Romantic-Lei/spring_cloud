package com.example.handler;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.example.domain.UppercaseRequest;
import com.example.domain.UppercaseResponse;

public class UppercaseFunctionHandler extends SpringBootRequestHandler<UppercaseRequest, UppercaseResponse> {

}
