package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * <h1>Project Number 2 for OC</h1>
 * 
 * @author KHEK Bodivann
 * @version : 1.0.2
 * 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		Map<String, Integer> countEstablished = analyticsCounter.counter(); // Analyse "symtoms.txt" file
		analyticsCounter.outputFile(countEstablished); // Put all occurence in "result.out" file
	}
}
