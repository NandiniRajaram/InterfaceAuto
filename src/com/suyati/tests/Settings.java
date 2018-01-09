package com.suyati.tests;

import org.junit.Test;

import com.suyati.frameworkengine.TestExecutor;

public class Settings {

	@Test
	public void testSettings() throws Exception {
		System.out.println("Starting Settings scenario");
		TestExecutor exe = new TestExecutor();
		exe.executeTest("Settings");
		System.out.println("Ending Settings  scenario");
	}

}
