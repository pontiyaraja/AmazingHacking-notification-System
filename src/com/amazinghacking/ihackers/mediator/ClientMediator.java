package com.amazinghacking.ihackers.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.amazinghack.ihackers.main.reader.CsvReader;
import com.amazinghack.ihackers.subscribers.SubscriberDetailsReader;

/**
 * This class is to read user input data from console
 * It reads the Item id and file path of the csv files.
 * @author Pandiyaraja
 *
 * @returns user requested data based on the user configuration.
 */
public class ClientMediator {
	private RequestItemDetails rqId = new RequestItemDetails();
	private CsvReader csvReader;
	public ClientMediator(){
		
	}
	public RequestItemDetails getRequestItemObject(){
		return rqId;
	}
	public void readCsvFile(String location){
		csvReader = new CsvReader(location);
		csvReader.readCSVFiles(rqId);
	}
	public void readSubscribersDetails(String configLocation){
		SubscriberDetailsReader sbd =new SubscriberDetailsReader(configLocation);
		sbd.readSubscriberDetails(csvReader);
	}
	public void readInputData(){
		String subscriberConfigurationFileLocation = null;
		String CsvFileLocation = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
				System.out.println("Enter Request Item Id");				
				rqId.setItemId(br.readLine());
				System.out.println("Enter subscriberConfigurationFileLocation");
				subscriberConfigurationFileLocation =br.readLine();
				System.out.println("Enter subscriberConfigurationFileLocation");
				CsvFileLocation =br.readLine();
				
				
				System.out.println(subscriberConfigurationFileLocation);
				System.out.println(CsvFileLocation);
				
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		readCsvFile(CsvFileLocation);
		readSubscribersDetails(subscriberConfigurationFileLocation);
	}
	public static void main(String args[]){
		while(true){
			ClientMediator clm =new ClientMediator();
			clm.readInputData();
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
