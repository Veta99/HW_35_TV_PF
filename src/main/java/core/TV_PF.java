package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



public class TV_PF {
	public static void main(String[] args) throws FileNotFoundException, IOException {
			String test_case_id = null;
			String url = null;
			String title_expected = null;
			Properties pf = new Properties();
					
			pf.load(new FileInputStream("C:/Workspace/HW_35_TV_PF/src/main/resources/pf.txt"));
				test_case_id = pf.getProperty("test_case_id");
				url = pf.getProperty("url");
				title_expected = pf.getProperty("title_expected");
			

			WebDriver driver = new HtmlUnitDriver(); //Version 1.2::HtmlUnit
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			
			if( title_expected.equals(title_actual)){
				System.out.println("Test Case ID: \t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actial: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
			}else {
				System.out.println("Test Case ID: \t\t" + test_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actial: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
			}
			driver.quit();
			}
}
//end
