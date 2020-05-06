package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	private static final String OUTPUTFILENAME = "result.out";

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
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				if (result.isEmpty()) {
					throw new IllegalStateException("The symtomps.txt file is empty, so result.out is not written");
				}

			} catch (IOException e) {
				System.err.println("Error access File : symptoms.txt");
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
	 * @throws IOException IOException look for any access file problems
	 */
	public void result(Map<String, Integer> res) throws IOException {
		FileWriter writer = new FileWriter(OUTPUTFILENAME);
		for (Map.Entry<String, Integer> entry : res.entrySet()) {
			try {
				writer.write(entry.getKey() + "=" + entry.getValue() + ";");
				writer.write(System.getProperty("line.separator"));
			} catch (IOException e) {
				System.err.println("Error access result.out file");
				e.printStackTrace();
			}
		}
		writer.close();
		System.out.println("result.out is successfully written");
	}
}
