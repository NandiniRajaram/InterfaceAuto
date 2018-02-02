package com.suyati.tests;
import org.junit.Test;

import com.suyati.frameworkengine.TestExecutor;



public class SiteDetails {

	@Test
	public void testSiteDetails() throws Exception {
		System.out.println("Starting SiteDetails scenario");
		TestExecutor exe = new TestExecutor();
		exe.executeTest("SiteDetails");
		System.out.println("Ending SiteDetails scenario");
	}

}
