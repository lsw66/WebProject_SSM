package dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import vo.CountryToCode;

public interface ICountryToCodeDAO {

	///查找数据库中所有数据，为下拉框做出准备
	public ArrayList<CountryToCode> getAll();
	
	///按照中文名查找，找出对应的Code
	public CountryToCode getByCountry(String Country);
	
}
