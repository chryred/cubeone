package com.shinsegae.smon.support;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class ControllerCubenoneSupport {


	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;
	protected HttpSession session;

	/**
	 * @throws Exception
	 */
	@PostConstruct
	protected void intilize() throws Exception {
		
	}

	

	/**
	 * 작성자: 함정길
	 * 작성일: 2015. 12. 11.
	 * 수정일: 2015. 12. 11.
	 * 목적 : Null 공백처리
	 *
	 * @param object
	 * @return
	 */
	protected String doNullToBlank(Object object)
	{
		if (object == null)
		{
			return "";
		}
		else
		{
			return String.valueOf(object);
		}
	}

	

	/**
	 * 작성자: ljg
	 * 작성일: 2016. 4. 7.
	 * 수정일: 2016. 4. 7.
	 * 목적 : HttpServletRequest객체의 파라미터로 부터 VO 생성
	 * @return
	 * @throws Exception
	 */
	protected Map<String, Object> toValueObject() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		Enumeration<?> en = request.getParameterNames();
		if (en == null) {
			return returnMap;
		}

		while(en.hasMoreElements()){
			String key = (String) en.nextElement();
			Object value = null;
			if (request.getParameter(key) == null) {
				if (request.getParameterValues(key) != null) {
					value = request.getParameterValues(key);
				}
			} else {
				value = request.getParameter(key);
			}
			returnMap.put(key, value);
		}


		return returnMap;
	}
	
}