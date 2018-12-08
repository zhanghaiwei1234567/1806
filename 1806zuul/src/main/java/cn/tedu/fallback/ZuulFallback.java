package cn.tedu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;
@Component
public class ZuulFallback implements ZuulFallbackProvider{
//获取路由application.name
	public String getRoute() {
		// TODO Auto-generated method stub
		return "provider-user";
	}
//设置返回值，通常用json体现
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {

			//响应体，具体返回内容 
			public InputStream getBody() throws IOException {
				String returnValue = "qing8";
				return new ByteArrayInputStream(returnValue.getBytes());
		
			}

			public HttpHeaders getHeaders() {
				//返回类型为json，字符集为u8
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return header;
			}

		
			//返回状态码
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			
			}

			
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}

			//返回的文件描述
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}

			
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}

}
