package com.amazinghack.ihackers.main.reader;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.amazinghacking.ihackers.mediator.RequestItemDetails;

public class CsvReader {
	private CsvDataAbstractProvider csvDRI =new CsvDataReaderImplementor();
	private String folderLocation=null;
	public CsvReader(String location){
		this.folderLocation=location;
	}
	
	public File[] getListOfCsvs(){
		File file =new File(folderLocation);
		File fileArray[]=file.listFiles();		
		return fileArray;
	}
	
	public List getResultData(){
		return csvDRI.getResultData();
	}
	public void readCSVFiles(RequestItemDetails rqId){
		File farry[]= getListOfCsvs();
		for(int i=0; i<farry.length; i++){
			//System.out.println(farry[i]);
			//System.out.println(csvDRI);
			if(farry[i].toString().endsWith(".csv")){
				csvDRI.readFileData(farry[i],rqId);
			}
			//System.out.println(farry[i]);
		}
	}
}
