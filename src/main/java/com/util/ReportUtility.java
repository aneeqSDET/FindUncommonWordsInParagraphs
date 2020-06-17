package com.util;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class ReportUtility {
	public ExtentReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
  @Test
  public void f() {
  }
  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
