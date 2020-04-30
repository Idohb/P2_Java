package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	private ReadSymptomDataFromFile readSymptomDataFromFile;
	private final String fileName = "symptoms.txt";

	/**
	 * Constructor of AnalyticsCounter
	 * 
	 */
	public AnalyticsCounter() {
		readSymptomDataFromFile = new ReadSymptomDataFromFile(fileName);
	}

	/**
	 * Read symptoms.txt file
	 *
	 * @return a raw listing of all Symptoms
	 * 
	 */
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
	 * @throws IOException
	 */
	public void outputFile(Map<String, Integer> res) throws IOException {
		readSymptomDataFromFile.result(res);
	}

}
