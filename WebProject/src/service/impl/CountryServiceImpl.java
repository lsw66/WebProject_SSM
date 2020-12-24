package service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.translate.demo.TransApi;

import dao.ICountryToCodeDAO;
import service.ICountryService;
import vo.CountryToCode;

@Service
public class CountryServiceImpl implements ICountryService{

	@Autowired
	private ICountryToCodeDAO dao;
	
	
	@Override
	public ArrayList<CountryToCode> getAllCode() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public CountryToCode getCode(String country) {
		return dao.getByCountry(country);
	}

	@Override
	public String getcontent(String in, String out, String outputcontent) {
		// TODO Auto-generated method stub
		TransApi api = new TransApi("20201214000647158", "nteLk8UfgilvaZ0lLE43");
		String query=api.getTransResult(outputcontent, in, out);
		return query;
	}

	@Override
	public String youdaoImg(String urlAddress) {
		System.out.println("asdjfkalsdfjadkls");
		String contentImg=youdao.yuodaoapi.youdao(urlAddress);
		return contentImg;
	}

	@Override
	public String youdaoVoice(String urlAddress) {
		String contentString=youdao.youdaoapiVoice.GetVoice(urlAddress);
		return contentString;
	}

}
