package com.ecms.http.converter;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author 沙文
 * @email  shaw053852@126.com 
 * @className UserService
 * @date   2018年3月16日上午9:56:21
 * @desc  [用一句话描述改文件的功能]
 */
public class JSONMessageConvertor extends AbstractHttpMessageConverter<Object> {

	@Override
	protected Object readInternal(Class<? extends Object> clz,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected boolean supports(Class<?> clz) {
		return true;
	}

	@Override
	protected void writeInternal(Object t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		String jsonString = JSON.toJSONString(t,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect);
		OutputStream os = outputMessage.getBody();
		os.write(jsonString.getBytes("UTF-8"));
		os.flush();
	}
}
