package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	public static ExtentReports configureReports() {
		
		//ExtentReports class will get the data in row format
		ExtentReports reports =new  ExtentReports();
		
		//ExtentSparkReporter will get the data from referance of ExtentReports and will convert in HTML format
		//In argument of ExtentSparkReporter, We give path or name of file to be generated
		ExtentSparkReporter htmlReporter =new ExtentSparkReporter("ExtentReports.html");
		
		
		// attachReporter is the method of ExtentReports class
		// This method accepts referance of ExtentSparkReporter as an argument
		// so in such way it gives the data to the ExtentSparkReporter andExtentSparkReporter converts it into html format
		reports.attachReporter(htmlReporter);
		
		// if want to print anything in the report, that will be written using setSystemInfo method of ExtentReports class,
		// it ascepts KEY and Value; 
		reports.setSystemInfo("SuiteName", "Regression");
		reports.setSystemInfo("Created By", "Sarvesh");
		return reports;
	}

}
