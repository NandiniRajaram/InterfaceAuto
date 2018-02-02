package com.suyati.tests;

import org.junit.Test;

import com.suyati.frameworkengine.TestExecutor;

public class Search {

	@Test
	public void testSettings() throws Exception {
		System.out.println("Starting Search scenario");
		TestExecutor exe = new TestExecutor();
		exe.executeTest("Search");
		
		
		System.out.println("Ending Search  scenario");
	}

}
