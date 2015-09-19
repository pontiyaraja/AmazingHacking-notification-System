package com.amazinghack.ihackers.main.reader;

import java.util.List;

public class CsFileAdapter {
	public CsvDataAbstractProvider csvdri;
	
	public CsFileAdapter(){
		
	}
	
	public List getDataList(){
		List resultList = csvdri.getResultData();
		return null;
	}
}
