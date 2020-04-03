/*
 * Copyright (c) Roman Osadchuk 2020.  ALL RIGHTS RESERVED.
 */

package com.osadchuk.security.bruteForce;

import java.time.Duration;
import java.time.LocalDateTime;

public class PasswordCracker {
	
	public static final char[] ALPHABET = "!#&()+,./0123456789:;=@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	//simple alphabet
	//	public static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public void findPassword(String password) {
		
		LocalDateTime start = LocalDateTime.now();
		BruteForce bruteForce = new BruteForce(ALPHABET, 1);
		
		String attempt = bruteForce.toString();
		while (true) {
			if (password.equals(attempt)) {
				System.out.println("Password was found:" + attempt);
				break;
			}
			attempt = bruteForce.toString();
			bruteForce.increment();
		}
		LocalDateTime end = LocalDateTime.now();
		printTimeDiff(start, end);
	}
	
	private void printTimeDiff(LocalDateTime start, LocalDateTime end) {
		String time = Duration.between(start, end).toString();
		time = time.replace("PT", "");
		time = time.replace("M", "m ");
		time = time.replace("S", "s ");
		System.out.println(time);
	}
	
}
