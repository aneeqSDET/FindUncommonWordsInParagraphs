package com.textCompare;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextComparison {
	public String[] getDifferences(String str1, String str2)
	{
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        
        for (String word: str1.replaceAll("\\p{Punct}", "").split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word: str2.replaceAll("\\p{Punct}", "").split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word: map.keySet()) {
            if (map.get(word) == 1) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
	/*
	************************************************************************************************
    In map String is the word and integer is used as the counter
    In the 2 loops word is the word and map.getOrDefault(word, 0) + 1 adds to the counter in the map
    Using Tree Map and adding CASE_INSENSITIVE_ORDER
	Using replaceAll("\\p{Punct}", "") to ignore punctuation
	In Case of HashMap use this to output words in alphabetical order Arrays.sort(result);
	************************************************************************************************
	 */
}