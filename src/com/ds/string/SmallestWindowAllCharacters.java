package com.ds.string;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowAllCharacters {

	private String source;
	private String pattern;
	private Map<Character, Integer> charToCountInPattern = new HashMap<>();

	public SmallestWindowAllCharacters(String source, String pattern) {
		this.source = source;
		this.pattern = pattern;

		for (int i = 0; i < pattern.length(); i++) {
			charToCountInPattern.compute(pattern.charAt(i), (key, value) -> {
				if (value == null)
					return 1;
				return value + 1;
			});
		}
	}

	public String getTheSmallestWindow() {
		int windowsMinStart = 0;
		int minimumLength = Integer.MAX_VALUE;

		int start = 0;
		int end = 0;
		int currentWindowLength = 0;

		int countOfValidChars = 0;
		Map<Character, Integer> charToCountInWindow = new HashMap<>();

		while (end < source.length() && (source.length() - start >= pattern.length())) {
			Character ch = source.charAt(end);
			currentWindowLength++;
			if (charToCountInPattern.containsKey(ch)) {
				charToCountInWindow.compute(ch, (key, value) -> {
					if (value == null)
						return 1;
					return value + 1;
				});

				if (charToCountInWindow.get(ch) <= charToCountInPattern.get(ch))
					countOfValidChars++;
			}

			if (countOfValidChars == pattern.length()) {
				System.out.println("end is : " + end + " start is : " + start);
				
				while(countOfValidChars == pattern.length()) {
					Character startCh = source.charAt(start);
					if (charToCountInWindow.containsKey(startCh) ) {
						charToCountInWindow.compute(startCh, (key, value) -> {
							return value - 1;
						});
						if(charToCountInPattern.get(startCh) > charToCountInWindow.get(startCh)) {
							countOfValidChars--;
						}
					}
					start++;
				}
				System.out.println("start after loop "+start);
				currentWindowLength = end - (start-1) + 1;
				if (currentWindowLength < minimumLength) {
					windowsMinStart = start-1;
					minimumLength = currentWindowLength;
				}
			}
			end++;
		}

		System.out.println("windowsminstart : " + windowsMinStart + " minimumlength : " + minimumLength);
		return source.substring(windowsMinStart, windowsMinStart + minimumLength);
	}
}
