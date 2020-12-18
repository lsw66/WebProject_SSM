package service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sun.tools.javac.util.Context.Key;

import vo.CountryToCode;


public interface ICountryService {
	//得到所有的Code
	public ArrayList<CountryToCode> getAllCode() ;
	//得到某个Code
	public CountryToCode getCode(String country);
	//取到翻译内容
	public String getcontent(String in,String out,String outputcontent);
}
