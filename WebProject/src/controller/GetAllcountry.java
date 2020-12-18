package controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.ICountryService;
import vo.CountryToCode;

@Controller
public class GetAllcountry {
	@Autowired
	private ICountryService service;
	
	@RequestMapping(value="/ajaxGetCountry.do",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<CountryToCode> queryCountry(){
		ArrayList<CountryToCode> list=service.getAllCode();
//		System.out.println("list:---"+list);
		return list;
	}
	
	@RequestMapping(value="/ajaxGetTranslate.do",method=RequestMethod.POST)
	@ResponseBody
	public String ReturnTranslate(String incode,String outcode,String text){
		
		CountryToCode in=service.getCode(incode);
		CountryToCode out=service.getCode(outcode);
		System.out.println("incode:"+in.getCode()+" outcode:"+out.getCode()+" text"+text);
		String str=service.getcontent(in.getCode(), out.getCode(), text);
		return str;
		
	}
}
