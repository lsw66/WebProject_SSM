package controller;

import java.io.IOException;
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
	
	@RequestMapping(value="/ajaxImg.do",method=RequestMethod.POST)
	@ResponseBody
	public String ReturnImg(String img) throws IOException{
		String imgString;
//		System.out.println("img.do:  "+img);
		System.out.println(img);
		String [] split=img.split(",");
//		System.out.println("减去后的："+split[1]);
		imgString=service.youdaoImg(split[1]);
		return imgString;
	}
	
	@RequestMapping(value="/ajaxVoice.do",method=RequestMethod.POST)
	@ResponseBody
	public String ReturnVoice(String voice){
		System.out.println(voice);
		String [] split=voice.split(",");
		String contentVoice=service.youdaoVoice(split[1]);
		return contentVoice;
	}
}
