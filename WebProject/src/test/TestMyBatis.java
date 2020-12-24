package test;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baidu.translate.demo.TransApi;
import com.fasterxml.jackson.annotation.JsonAlias;

import controller.huawei;
import service.ICountryService;
import vo.CountryToCode;
import youdao.youdaoapiVoice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	
	@Autowired
	private ICountryService serviceo;
	
	@Test
	public void test01() throws Exception{
//		CountryToCode in;
//		CountryToCode out;
//		in=serviceo.getCode("中文");
//		out=serviceo.getCode("英语");
//		System.out.println(in.getCode());
//		System.out.println(out.getCode());
//		//TransApi api = new TransApi("20201214000647158", "nteLk8UfgilvaZ0lLE43");
//
//        String query = "高度600米";
//
//        
//      //  System.out.println(api.getTransResult(query, in.getCode(), out.getCode()));
//        ArrayList<CountryToCode> list=serviceo.getAllCode();
//        System.out.println(list);
		
//        youdao.yuodaoapi.youdao();
//		String kkkString=youdao.yuodaoapi.loadAsBase64("D:/java/youdao.png");
//		System.out.println(kkkString);
//		String string=youdaoapiVoice.GetVoice("D:/java/nls-sample-16k.wav");
//		System.out.println(string);
		
		String aaaString=qqqqq.aaaaa.GetApiInfo();
	}	
}
