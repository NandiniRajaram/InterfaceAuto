package com.suyati.tests;
import org.junit.Test;

import com.suyati.frameworkengine.TestExecutor;



public class ChangeCompany {

	@Test
	public void testChangeCompany() throws Exception {
		System.out.println("Starting ChangeCompany  scenario");
		TestExecutor exe = new TestExecutor();
		exe.executeTest("ChangeCompany");
		System.out.println("Ending ChangeCompany scenario");
	}

}
