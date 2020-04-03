/*
 * Copyright (c) Roman Osadchuk 2020.  ALL RIGHTS RESERVED.
 */

package com.osadchuk.security.bruteForce;

import java.util.Arrays;

public class BruteForce {
	
	private char[] charSet; // Character Set
	private char[] currentAttempt; // Current Attempt
	
	public BruteForce(char[] characterSet, int guessLength) {
		Arrays.sort(characterSet);
		charSet = characterSet;// set of characters which password might contain
		currentAttempt = new char[guessLength];// current combination of characters (possible password)
		Arrays.fill(currentAttempt, charSet[0]);
	}
	
	/**
	 * Generates next combination of characters. For example
	 * a
	 * b
	 * ...
	 * z
	 * aa
	 * ab
	 * ...
	 * zz
	 * ...
	 * aaa
	 * aab
	 * ....
	 */
	public void increment() {
		int index = currentAttempt.length - 1;
		while (index >= 0) {
			if (currentAttempt[index] == charSet[charSet.length - 1]) {
				if (index == 0) {
					int newLength = currentAttempt.length + 1;
					currentAttempt = new char[newLength];
					Arrays.fill(currentAttempt, charSet[0]);
					break;
				} else {
					currentAttempt[index] = charSet[0];
					index--;
				}
			} else {
				currentAttempt[index] = charSet[Arrays.binarySearch(charSet, currentAttempt[index]) + 1];
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return String.valueOf(currentAttempt);
	}
}
