package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class AnalyticsCounter {

	// découpage du main
	public static void main(String[] args) throws IOException{ // Exception must be declared to be thrown
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		List<String> line = analyticsCounter.reader("symptoms.txt");
		analyticsCounter.result(line);
	}
	// Test utilisation de GetSymptom
	public List<String> reader(String fileName) {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(fileName);
		return readSymptomDataFromFile.getSymptoms();
	}

	public void result(List<String> line) throws IOException{
		FileWriter writer = new FileWriter("result.out");
		String lineFromFile;
		line.forEach(temp -> {
			//System.out.println(temp);
			try {
				writer.write(temp);
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		writer.close();
	}

}
