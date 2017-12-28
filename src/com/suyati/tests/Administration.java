package com.suyati.tests;
import org.junit.Test;

import com.suyati.frameworkengine.TestExecutor;



public class Administration {

	@Test
	public void testAdministration() throws Exception {
		System.out.println("Starting Administration   scenario");
		TestExecutor exe = new TestExecutor();
		exe.executeTest("Administration");
		System.out.println("Ending Administration scenario");
	}

}
