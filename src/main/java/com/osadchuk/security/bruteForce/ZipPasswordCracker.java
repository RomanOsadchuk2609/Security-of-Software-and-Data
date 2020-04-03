/*
 * Copyright (c) Roman Osadchuk 2020.  ALL RIGHTS RESERVED.
 */

package com.osadchuk.security.bruteForce;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.time.Duration;
import java.time.LocalDateTime;

public class ZipPasswordCracker {
	
	public static final char[] ALPHABET = "!#&()+,./0123456789:;=@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
	//simple alphabet
	//	public static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public void findZipPassword(String zipFilePath) {
		// Get unzip file path by removing .zi-+p from the zipped file name
		String unZipFilePath = zipFilePath.substring(0, zipFilePath.lastIndexOf("."));
		ZipFile zipFile = openZipFile(zipFilePath);
		
		if (zipFile != null) {
			LocalDateTime start = LocalDateTime.now();
			BruteForce bruteForce = new BruteForce(ALPHABET, 1);
			
			String attempt = bruteForce.toString();
			while (true) {
				try {
					zipFile.setPassword(attempt);
					zipFile.extractAll(unZipFilePath);// trows ZipException if password is incorrect
					System.out.println("Password was found:" + attempt);
					break;
				} catch (ZipException e) {
					//Password is incorrect
					//continue
				}
				attempt = bruteForce.toString();
				bruteForce.increment();//generate next password
				
			}
			LocalDateTime end = LocalDateTime.now();
			printTimeDiff(start, end);
		}
	}
	
	private ZipFile openZipFile(String path) {
		// Get unzip file path by removing .zi-+p from the zipped file name
		String unZipFilePath = path.substring(0, path.lastIndexOf("."));
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(path);
		} catch (ZipException e) {
			e.printStackTrace();
		}
		return zipFile;
	}
	
	private void printTimeDiff(LocalDateTime start, LocalDateTime end) {
		String time = Duration.between(start, end).toString();
		time = time.replace("PT", "");
		time = time.replace("M", "m ");
		time = time.replace("S", "s ");
		System.out.println(time);
	}
	
}
