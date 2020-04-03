/*
 * Copyright (c) Roman Osadchuk 2020.  ALL RIGHTS RESERVED.
 */

package com.osadchuk.security.bruteForce;

public class Main {
	
	private static final String ZIP_FILE_PATH = "src/main/java/com/osadchuk/security/bruteForce/test.zip";
	
	private static final ZipPasswordCracker zipPasswordCracker = new ZipPasswordCracker();
	
	private static final PasswordCracker passwordCracker = new PasswordCracker();
	
	public static void main(String[] args) {
		passwordCracker.findPassword("An!s0");
		passwordCracker.findPassword("abcde");
		passwordCracker.findPassword("(91=3");
		passwordCracker.findPassword("fwesf");
		passwordCracker.findPassword("An!)f");
		passwordCracker.findPassword("A)03k");
		passwordCracker.findPassword("(Hvf)");
		passwordCracker.findPassword("R0mAn");
//		zipPasswordCracker.findZipPassword(ZIP_FILE_PATH);
	}
	
}
