package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	private final String outputFileName = "result.out";

	/**
	 * Constructor of ReadSymptomDataFromFile
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Read symptoms.txt file
	 *
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>(); // Explicit type argument String can be replaced with <>

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("Error access File : symptoms.txt");
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * countNumberSymptoms read the object List to count all symtoms
	 *
	 * @param listFromFile : returned by getSymptom
	 * @return a map HashMap with all occurence
	 */
	public Map<String, Integer> countNumberSymptoms(List<String> listFromFile) {
		TreeMap<String, Integer> mapSymptoms = new TreeMap<>();
		if (listFromFile != null && !listFromFile.isEmpty()) {
			for (String temp : listFromFile) {
				mapSymptoms.put(temp, !mapSymptoms.containsKey(temp) ? 1 : (mapSymptoms.get(temp) + 1));
			}
		}
		return mapSymptoms;
	}

	/**
	 * put all result in result.out file
	 *
	 * @param res : returned by countNumberSymptoms
	 * @throws IOException
	 */
	public void result(Map<String, Integer> res) throws IOException {
		FileWriter writer = new FileWriter(outputFileName);
		for (Map.Entry<String, Integer> entry : res.entrySet()) {
			try {
				writer.write(entry.getKey() + "=" + entry.getValue() + ";");
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {
				System.out.println("Error access result.out file");
				e.printStackTrace();
			}
		}
		writer.close();
		System.out.println("result.out is successfully written");
	}
}
