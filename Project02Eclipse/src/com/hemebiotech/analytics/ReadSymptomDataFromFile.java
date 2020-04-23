package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>(); // Explicit type argument String can be replaced with <>
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public Map<String,Integer> countNumberSymptoms(List<String> listFromFile) {
		Map<String, Integer> mapSymptoms = new HashMap<>();
		if (listFromFile != null && !listFromFile.isEmpty()){
			listFromFile.forEach (temp ->
				mapSymptoms.put( temp,
								 !mapSymptoms.containsKey(temp) ? 1 : (mapSymptoms.get(temp) + 1))
			);
		}
		return mapSymptoms;
	}

}
