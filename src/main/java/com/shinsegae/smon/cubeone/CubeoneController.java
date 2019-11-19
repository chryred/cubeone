package com.shinsegae.smon.cubeone;

import java.io.UnsupportedEncodingException;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cubeone.CubeOneAPI;
import com.shinsegae.smon.model.CubeoneVO;
import com.shinsegae.smon.support.ControllerCubenoneSupport;
import com.shinsegae.smon.util.NLogger;

@RestController
@Scope("request")
@RequestMapping("/api")
public class CubeoneController extends ControllerCubenoneSupport {
	
	
	/**
	 * 큐브원 단방향 암호화
	 * @param msg
	 * @return String 256byte 암호화
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/cohashsalt", method = RequestMethod.POST)
	public CubeoneVO cohashsalt(CubeoneVO cubeoneVO) throws UnsupportedEncodingException {
		NLogger.debug("cubeoneVO : ", cubeoneVO.toString());
		
		String strEncrpt = "Not Encrypted";
		byte[] errbyte = new byte[8];
		try {
			strEncrpt = CubeOneAPI.cohashsalt(cubeoneVO.getMsg(), "", 256, errbyte);
			cubeoneVO.setRetMsg(strEncrpt);
			
			cubeoneVO.setErrorMsg(new String(errbyte, "UTF-8"));
		} catch(Error e) {
			cubeoneVO.setStatus("500");
		} catch (UnsupportedEncodingException e) {
			cubeoneVO.setStatus("501");
		}
		
		return cubeoneVO;
	}
	
	
	/**
	 * 큐브원 AP 암호화 함수
	 * @param strMsg 암호화할 문자열
	 * @param nCrudLog 로그 정보(10:select, 11:insert, 12(update), 13(delete)
	 * @param strItemCd 아이템코드 (PWD, CARD, ...)
	 * @param strTableNm (TABLE명)
	 * @param strColNm (컬럼명)
	 * @return String 암호화된 문자열
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/coencbyte", method = RequestMethod.POST)
	public CubeoneVO coencbyte(CubeoneVO cubeoneVO) {
		NLogger.debug("cubeoneVO : ", cubeoneVO.toString());
		
		String strEncrpt = "Not Encrypted";
		byte[] errbyte = new byte[8];
		try {
			strEncrpt = CubeOneAPI.coencbyte(cubeoneVO.getMsg().getBytes(), cubeoneVO.getItemCd(), cubeoneVO.getCrudLog() ,cubeoneVO.getTableName(), cubeoneVO.getColumnName(), errbyte);
			cubeoneVO.setRetMsg(strEncrpt);
			
			cubeoneVO.setErrorMsg(new String(errbyte, "UTF-8"));
		} catch(Error e) {
			cubeoneVO.setStatus("500");
		} catch (UnsupportedEncodingException e) {
			cubeoneVO.setStatus("501");
		}
		
		return cubeoneVO;
	}
	
	/**
	 * 큐브원 AP 복호화 함수
	 * @param strEncMsg 복호화할 문자열
	 * @param strCrudLog
	 * @param strItemCd 아이템코드 (PWD, CARD, ...)
	 * @param strTableNm (TABLE명)
	 * @param strColNm (컬럼명)
	 * @return String 복호화된 문자열
	 */
	@RequestMapping(value = "/codecchar", method = RequestMethod.POST)
	public CubeoneVO codecchar(CubeoneVO cubeoneVO) {
		NLogger.debug("cubeoneVO : ", cubeoneVO.toString());
		
		String strEncrpt = "Not Decrypted";
		byte[] errbyte = new byte[8];
		try {
			strEncrpt = CubeOneAPI.codecchar(cubeoneVO.getMsg(), cubeoneVO.getItemCd(), cubeoneVO.getCrudLog() ,cubeoneVO.getTableName(), cubeoneVO.getColumnName(), errbyte);
			cubeoneVO.setRetMsg(strEncrpt);
			
			cubeoneVO.setErrorMsg(new String(errbyte, "UTF-8"));
		} catch(Error e) {
			cubeoneVO.setStatus("500");
		} catch (UnsupportedEncodingException e) {
			cubeoneVO.setStatus("501");
		}

		return cubeoneVO;
	}
	
	
	/**
	 * 큐브원 AP 인덱스 암호화 함수
	 * @param strMsg
	 * @param strItemCd
	 * @param strTableNm
	 * @param strColNm
	 * @return
	 */
	@RequestMapping(value = "/coindexchar", method = RequestMethod.POST)
	public CubeoneVO coindexchar(CubeoneVO cubeoneVO) {
		NLogger.debug("cubeoneVO : ", cubeoneVO.toString());
		
		String strEncrpt = "Not Encrypted";
		byte[] errbyte = new byte[8];
		try {
			strEncrpt = CubeOneAPI.coindexchar(cubeoneVO.getMsg(), cubeoneVO.getItemCd(), cubeoneVO.getTableName(), cubeoneVO.getColumnName(), errbyte);
			cubeoneVO.setRetMsg(strEncrpt);
			
			cubeoneVO.setErrorMsg(new String(errbyte, "UTF-8"));
		} catch(Error e) {
			cubeoneVO.setStatus("500");
		} catch (UnsupportedEncodingException e) {
			cubeoneVO.setStatus("501");
		}
		
		return cubeoneVO;
	}
	
	/**
	 * 큐브원 AP 인덱스 복호화 함수
	 * @param strEncMsg
	 * @param strItemCd
	 * @param strTableNm
	 * @param strColNm
	 * @return
	 */
	@RequestMapping(value = "/coindexcharsel", method = RequestMethod.POST)
	public CubeoneVO coindexcharsel(CubeoneVO cubeoneVO) {
		NLogger.debug("cubeoneVO : ", cubeoneVO.toString());
		
		String strEncrpt = "Not Decrypted";
		byte[] errbyte = new byte[8];
		try {
			strEncrpt = CubeOneAPI.coindexchar(cubeoneVO.getMsg(), cubeoneVO.getItemCd(), cubeoneVO.getTableName(), cubeoneVO.getColumnName(), errbyte);
			cubeoneVO.setRetMsg(strEncrpt);
			
			cubeoneVO.setErrorMsg(new String(errbyte, "UTF-8"));
		} catch(Error e) {
			cubeoneVO.setStatus("500");
		} catch (UnsupportedEncodingException e) {
			cubeoneVO.setStatus("501");
		}
		
		return cubeoneVO;
	}

}
