package com.amazinghack.ihackers.main.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.amazinghacking.ihackers.mediator.RequestItemDetails;

public class CsvDataReaderImplementor extends CsvDataAbstractProvider {

	public ArrayList resultArray = new ArrayList();
	static int count = 0;

	public CsvDataReaderImplementor() {

	}

	public void readFileData(File fileLocation,RequestItemDetails rqItem) {
		// TODO Auto-generated method stub
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			StringTokenizer stk;
			while ((line = br.readLine()) != null) {
				Map map = new HashMap();
				if (line.contains(rqItem.getItemId())) {
					stk = new StringTokenizer(line, ",");
					synchronized (stk) {
						if (stk.countTokens() >= 3) {
							stk.nextToken();
							map.put(stk.nextToken(), stk.nextToken());
						}
					}
				}
				if(!map.isEmpty()){
					storeMapData(map);
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List getResultData() {
		// TODO Auto-generated method stub
		return resultArray;
	}

	public void storeMapData(Map map) {
		resultArray.add(count, map);
		System.out.println(resultArray);
		count++;
	}

}
