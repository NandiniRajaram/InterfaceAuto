package com.suyati.tests;

import org.junit.Test;

import com.suyati.frameworkengine.TestExecutor;

public class LogoVerification {

	@Test
	public void testSettings() throws Exception {
		System.out.println("Starting Logo Verification  scenario");
		TestExecutor exe = new TestExecutor();
		exe.executeTest("LogoVerification ");
		System.out.println("Ending Logo Verification  scenario");
	}

}
