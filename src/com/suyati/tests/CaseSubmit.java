package com.suyati.tests;
import org.junit.Test;

import com.suyati.frameworkengine.TestExecutor;



public class CaseSubmit {

	@Test
	public void testCaseSubmit() throws Exception {
		System.out.println("Starting CaseSubmit scenario");
		TestExecutor exe = new TestExecutor();
		exe.executeTest("CaseSubmit");
		System.out.println("Ending CaseSubmit scenario");
	}

}
