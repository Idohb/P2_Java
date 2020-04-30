package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	List<String> getSymptoms();

	/**
	 * Analyse the occurrence of all symptoms
	 *
	 * @param listFromFile : returned by getSymptom
	 * @return a map with all occurence
	 */
	Map<String, Integer> countNumberSymptoms(List<String> listFromFile);

	/**
	 * put result in the file result.out
	 *
	 * @param res : returned by countNumberSymptoms
	 * @throws IOException
	 */
	void result(Map<String, Integer> res) throws IOException;

}
