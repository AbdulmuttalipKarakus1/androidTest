package testappium.crossbrowser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Hello world!
 *
 */
public class App 
{
	protected AppiumDriver<MobileElement> driver = null;
	
	
	 @BeforeTest
	 public void setUp() throws MalformedURLException {
	  // Created object of DesiredCapabilities class.
	  DesiredCapabilities capabilities = new DesiredCapabilities();

	  // Set android deviceName desired capability. Set your device name.
	  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");

	  // Set BROWSER_NAME desired capability. It's Android in our case here.
	  //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

	  // Set android VERSION desired capability. Set your mobile device's OS version.
	 // capabilities.setCapability(CapabilityType.VERSION, "9");

	  // Set android platformName desired capability. It's Android in our case here.
	  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	 
	  // Set android appPackage desired capability. It is
	  // com.android.calculator2 for calculator application.
	  // Set your application's appPackage if you are using any other app.
	 // capabilities.setCapability("appPackage", "com.android.calculator2");
	 capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
	  
	  // Set android appActivity desired capability. It is
	  // com.android.calculator2.Calculator for calculator application.
	  // Set your application's appPackage if you are using any other app.
// capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	 capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".HomeScreenActivity");
	  
	  capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

	  // Created object of RemoteWebDriver will all set capabilities.
	  // Set appium server address and port number in URL string.
	  // It will launch calculator app in android device.
	 // driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	  driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 }
	 
	    @Test
	    public void testCal() throws Exception {
	       System.out.println("test basarili");
	       
	     //  driver.findElements(By.xpath("//android.widget.Button")).get(0).click();
	       
	    // Enter the text in textbox
	      driver.findElement(By.id("android:id/button1")).click();
	      driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("test deneme yazisi");
	       
	       
	       // click on registration button  
	                                          
	       driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
	       
	    }
	 
	    @AfterTest
	    public void teardown(){
	        //close the app
	    	//driver.quit();
	    }
}
