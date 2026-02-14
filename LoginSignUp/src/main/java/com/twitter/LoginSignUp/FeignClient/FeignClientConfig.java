package com.twitter.LoginSignUp.FeignClient;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.okhttp.OkHttpClient;

@Configuration
public class FeignClientConfig {
	
	
	public OkHttpClient httpClient() {
		return new OkHttpClient();
	}
	
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; // Logs headers, body, and metadata
    }


}
