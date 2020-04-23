package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class AnalyticsCounter {

	static final ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");

	public static void main(String[] args) throws IOException{ // Exception must be declared to be thrown
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		List<String> line = analyticsCounter.reader();
		Map<String, Integer> countEstablished = readSymptomDataFromFile.countNumberSymptoms(line);


		analyticsCounter.outputFile(countEstablished);
	}

	public List<String> reader() {
		return readSymptomDataFromFile.getSymptoms();
	}

	public void outputFile(Map<String, Integer> res) throws IOException{
		readSymptomDataFromFile.result(res);
	}

}
