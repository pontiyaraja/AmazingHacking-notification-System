package com.amazinghacking.ihackers.notification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.amazinghack.ihackers.main.reader.CsvReader;
import com.amazinghack.ihackers.subscribers.SubscribersDetail;

public class NotificationGenerator {	
	

	public NotificationGenerator() {

	}
	/**
	 * This method Parse the generates notification Data and sends to the subscriber
	 */

	public void processNotificationData(SubscribersDetail subscribeDetails, CsvReader csRdr) {
		subscribeDetails.getSubscriberId();
		synchronized (subscribeDetails) {			
			StringTokenizer stk = new StringTokenizer(
					subscribeDetails.getConfiguratin(), ":");
			Map map=new HashMap();
			while (stk.hasMoreTokens()) {
				System.out.println(stk.nextToken());
				String nxtToken = stk.nextToken();
				List resList = csRdr.getResultData();
				for(int i=0; i<resList.size();i++){
					Map mapval = (Map) resList.get(i);
					if(nxtToken.indexOf("authors")>0){
					//|| stk.nextToken().indexOf("date<")>0 || stk.nextToken().indexOf("date<")>0){
						map.put("authors",mapval.get("authors"));
						
					}
					if(nxtToken.indexOf("title")>0){
						map.put("title",mapval.get("title"));
					}
					if(nxtToken.indexOf("publisher")>0){
						map.put("publisher",mapval.get("publisher"));
					}
					if(nxtToken.indexOf("list price:>=")>0){
						int val = Integer.parseInt(nxtToken.substring(nxtToken.indexOf(">=")+1, nxtToken.length()));
						if(Integer.parseInt((String) mapval.get("list price"))>=val){
							map.put("list price",mapval.get("list price"));
						}
					}else if(nxtToken.indexOf("list price:>")>0){
						int val = Integer.parseInt(nxtToken.substring(nxtToken.indexOf(">")+1, nxtToken.length()));
						if(Integer.parseInt((String) mapval.get("list price"))>val){
							map.put("list price",mapval.get("list price"));
						}
					}
					if(nxtToken.indexOf("list price:<=")>0){
						int val = Integer.parseInt(nxtToken.substring(nxtToken.indexOf("<=")+1, nxtToken.length()));
						if(Integer.parseInt((String) mapval.get("list price"))<=val){
							map.put("list price",mapval.get("list price"));
						}
					}else if(nxtToken.indexOf("list price:>")>0){
						int val = Integer.parseInt(nxtToken.substring(nxtToken.indexOf("<")+1, nxtToken.length()));
						if(Integer.parseInt((String) mapval.get("list price"))<val){
							map.put("list price",mapval.get("list price"));
						}
					}					
				}									
				
			}
		}

	}
	public Date dateParser(String date){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");		
		Date dateD = null;
		try {

			dateD = formatter.parse(date);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateD;
	}
}
