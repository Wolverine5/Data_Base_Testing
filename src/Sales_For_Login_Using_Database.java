import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sales_For_Login_Using_Database {

	public static void main(String[] args) throws SQLException {
		
		String host="localhost";
		String port="3306";
		
		Connection  con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Sales_Force_Login", "root", "Adi@rockstar5");
		                                                  //String url             //User        //Password
		Statement s=con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from login_details where fname='Mangya'");
		
		while(rs.next())
		{
			
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
			

			System.setProperty("webdriver.chrome.driver","C:\\Selenium_Drivers\\chromedriver_win32\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        
	        driver.get("https://login.salesforce.com/?locale=in");
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	         driver.findElement(By.cssSelector("#username")).sendKeys(rs.getString("username"));
	        
	        driver.findElement(By.cssSelector("#password")).sendKeys(rs.getString("password"));
	        
	        driver.findElement(By.cssSelector("#Login")).click();
		}
		
		
		


	}

}
