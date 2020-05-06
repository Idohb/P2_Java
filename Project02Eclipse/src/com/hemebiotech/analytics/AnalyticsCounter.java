package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	private ReadSymptomDataFromFile readSymptomDataFromFile;
	private static final String FILENAME = "symptoms.txt";

	/**
	 * Constructor of AnalyticsCounter
	 * 
	 */
	public AnalyticsCounter() {
		readSymptomDataFromFile = new ReadSymptomDataFromFile(FILENAME);
	}

	private List<String> reader() {
		return readSymptomDataFromFile.getSymptoms();
	}

	/**
	 * The function "counter" read the object List to count all symtoms
	 *
	 * @return a map Map sorted with all occurence Symptoms
	 */
	public Map<String, Integer> counter() {
		return readSymptomDataFromFile.countNumberSymptoms(this.reader());
	}

	/**
	 * put all result in result.out file
	 *
	 * @param res : returned by counter()
	 * @throws IOException look for any access file problems
	 */
	public void outputFile(Map<String, Integer> res) throws IOException {
		readSymptomDataFromFile.result(res);
	}

}
