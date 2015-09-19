package com.amazinghack.ihackers.subscribers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.amazinghack.ihackers.main.reader.CsvReader;
import com.amazinghacking.ihackers.notification.NotificationGenerator;

public class SubscriberDetailsReader {
	NotificationGenerator ng=new NotificationGenerator();
	SubscribersDetail subDetail = new SubscribersDetail();
	String filePath =null;
	public SubscriberDetailsReader(String fileString){
		this.filePath=fileString;
	}
	public List readSubscriberDetails(CsvReader csvReader){
		List subscriberList = new ArrayList();
		try {
	    	BufferedReader br = new BufferedReader(new FileReader(filePath));
	    	StringTokenizer stk;
	    	String line=null;	    	
			while((line=br.readLine())!=null){	
				System.out.println(" Updated data -----> "+line);
			    	stk = new StringTokenizer(line, "=");
			    	synchronized (stk) {
			    		if(stk.countTokens()>=2){			    			
			    			subDetail.setSubscriberId(stk.nextToken());
			    			subDetail.setConfiguratin(stk.nextToken());
			    		}
			    		ng.processNotificationData(subDetail,csvReader);
					}
			    	subscriberList.add(subDetail);
			}
			br.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subscriberList;
	}
}
