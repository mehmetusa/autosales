//package StepDefinitions;
//
//import java.util.List;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Print_WebTable_Data {
//
//public static void main(String args[]) {
//
//System.setProperty("webdriver.chrome.driver", "Path to your chromedriver.exe");
//WebDriver driver = new ChromeDriver();
//driver.get("http://www.stqatools.com");
//driver.manage().window().maximize();
//// Identify the table
////<a href="http://stqatools.com/selenium-webelement-commands/">
//WebElement table = driver.findElement(By.id("tableId"));
//// Get all rows (tr tags)
//List<WebElement> rows = table.findElements(By.tagName("tr"));
//String Expected = "CellName";
//// Print data from each row (Data from each td tag)
//for (WebElement row : rows) {
//	List<WebElement> cols = row.findElements(By.tagName("td"));
//	for (WebElement col : cols) {
//		System.out.print(col.getText() + "\t");
//		String Actual = col.getText();
//// Check Expected Cell is present or not in WebTable
//if (Actual.equals(Expected)) {
//	System.out.println("Cell Exist in WebTable...");}}}}}
