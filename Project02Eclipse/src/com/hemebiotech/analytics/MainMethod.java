package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public class MainMethod {

	public static void main(String[] args) throws IOException { // Exception must be declared to be thrown
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		Map<String, Integer> countEstablished = analyticsCounter.counter();
		analyticsCounter.outputFile(countEstablished);
	}
}
