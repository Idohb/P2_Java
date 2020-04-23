package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class AnalyticsCounter {
/*	private static int headacheCount = 0; // initialize to 0
	private static int rashCount = 0; // initialize to 0
	private static int pupilCount = 0; // initialize to 0
	//test git 3
	public static void main(String[] args) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0; // set i to 0
		int headCount = 0; // counts headaches
		while (line != null) {
			i++; // increment i
			System.out.println("symptom from file: " + line);
			if (line.contains("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.contains("rash")) {
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}

		// next generate output
		FileWriter writer = new FileWriter("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}*/

	// découpage du main
	public static void main(String[] args) throws IOException{ // Exception must be declared to be thrown
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		String line = analyticsCounter.reader("symptoms.txt");
		analyticsCounter.result(line);
	}
	// Test première ligne avant de faire appel à GetSymptom
	public String reader(String fileName) {
		String line = "none";
		if (fileName != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				line = reader.readLine();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return line;
	}

	public void result(String line) throws IOException{
		FileWriter writer = new FileWriter("result.out");
		writer.write(line);
		writer.close();
	}

}
