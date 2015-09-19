package com.amazinghack.ihackers.main.reader;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.amazinghacking.ihackers.mediator.RequestItemDetails;

public abstract class CsvDataAbstractProvider {

	public abstract void readFileData(File farry, RequestItemDetails rqItem);
	public abstract List getResultData();
}
