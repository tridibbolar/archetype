package ${groupId}.lambda.handler;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.JSONParser;

import ${groupId}.domain.common.Error;
import ${groupId}.domain.common.Result;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.util.StringUtils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



import ${groupId}.domain.svc.${service}Event;
import ${groupId}.domain.svc.${service}Response;

public class ${service}LambdaHandler implements RequestHandler<${service}Event, ${service}Response> {
	JSONParser parser = new JSONParser();
	static final Logger LOG = LogManager.getLogger(${service}LambdaHandler.class);
	static final ObjectMapper objectMapper = new ObjectMapper();

	public ${service}Response handleRequest(${service}Event event, Context context) {
		LOG.info("Inside ${service}LambdaHandler");
		${service}Response response = new ${service}Response();

		if (!StringUtils.isNullOrEmpty(event.getWarmUp())) {
			LOG.info("${service}LambdaHandler Warming Up...");
			Result result = new Result("WARMUP", null);
			response.setResult(result);
		} else {
			//TODO
		}
		return response;
	}
}