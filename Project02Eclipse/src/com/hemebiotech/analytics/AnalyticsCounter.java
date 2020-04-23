package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class AnalyticsCounter {

	static final ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");

	public static void main(String[] args) throws IOException{ // Exception must be declared to be thrown
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		List<String> line = analyticsCounter.reader();
		Map<String, Integer> countEstablished = readSymptomDataFromFile.countNumberSymptoms(line);


		analyticsCounter.result(countEstablished);
	}
	// Test utilisation de GetSymptom
	public List<String> reader() {
		return readSymptomDataFromFile.getSymptoms();
	}

	public void result(Map<String, Integer> res) throws IOException{
		FileWriter writer = new FileWriter("result.out");
		res.forEach( (symptom, count) -> {
			//System.out.println(temp);
			try {
				writer.write(symptom + ":" + count);
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		writer.close();
	}

}
