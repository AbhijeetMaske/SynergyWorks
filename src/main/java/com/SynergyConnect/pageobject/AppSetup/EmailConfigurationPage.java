package com.SynergyConnect.pageobject.AppSetup;

import java.sql.Array;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.SynergyConnect.utilities.AlertUtils;
import com.SynergyConnect.utilities.ElementInteractionUtils;

public class EmailConfigurationPage {
	WebDriver driver;
	ElementInteractionUtils EI;
	AlertUtils AU;
	private static final Logger logger = LogManager.getLogger(EmailConfigurationPage.class);
	public EmailConfigurationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		EI = new ElementInteractionUtils(driver);
		AU = new AlertUtils(driver);

	}

	// identify WebElements

	@FindBy(xpath = "//span[contains(text(),'App Setup')]")
	private WebElement ddlAppSetup;

	@FindBy(xpath = "//span[contains(text(),'Email Configuration')]")
	private WebElement ddlEmailConfiguration;

	@FindBy(xpath = "//*[@id=\"collapseBtn\"]")
	private WebElement btnEmailConfigAdd;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement txtPersonName;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement txtEmail;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//select[@id='tls']")
	private WebElement ddlTls;

	@FindBy(xpath = "//input[@id='port']")
	private WebElement txtPort;

	@FindBy(xpath = "//input[@id='host']")
	private WebElement txtHost;

	@FindBy(xpath = "//button[@id='addEmailConfigButton']")
	private WebElement btnAdd;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	private WebElement btnCancel;

	@FindBy(id = "emailConfigTable")
	private WebElement emailConfigurationTable;

	//
	@Test
	public void redirectToEmailConfigAndValidateUrl() throws InterruptedException {
		ElementInteractionUtils.click(ddlAppSetup);
		ElementInteractionUtils.click(ddlEmailConfiguration);
	}

	@Test
	public void emailConfigurtionFormvalidation() {
		//ElementInteractionUtils.click(btnEmailConfigAdd);

	}

	@Test
	public void addEmailConfigurtion() {
		ElementInteractionUtils.click(btnEmailConfigAdd);
		ElementInteractionUtils.sendKeys(txtPersonName, "Works");
		ElementInteractionUtils.sendKeys(txtEmail, "info@synergyconnect.in");
		ElementInteractionUtils.sendKeys(txtPassword, "Leadership@2016");// ddlTls
		ElementInteractionUtils.sendKeys(ddlTls, "Leadership@2016");
		ElementInteractionUtils.selectByVisibleText(ddlTls, "Yes");
		ElementInteractionUtils.sendKeys(txtPort, "587");
		ElementInteractionUtils.sendKeys(txtHost, "smtp.office365.com");
		ElementInteractionUtils.click(btnAdd);
		AU.getToasterText();

	}

	@Test
	public void verifyAddedEmailConfigurtion() {
		  // tableId , tableColumnIndex, 
		try {
			String tableId = "emailConfigTable";
			int tableColumnIndex = 3;
			String searchText = "info@synergyconnect.in";
			// identify table
			//WebElement table = driver.findElement(By.xpath("//*[@id=\"emailConfigTable\"]/tbody"));
			WebElement table = driver.findElement(By.id(tableId));
			//System.out.println("jsApprovalTable---->"+table);
			// identify rows of table.
			List<WebElement> approvalTable = table.findElements(By.tagName("tr"));
			System.out.println("approvalTable: -->"+approvalTable);
			WebElement tableData = driver.findElement(By.id(tableId));
			String tableSize = tableData.getText();
			System.out.println("tableSize--->"+tableSize);
			String[] aSplit = tableSize.split(" ");
			System.out.println("aSplit--->"+aSplit);
			String tabledatarow = aSplit[3];
			int tabledatarowdumy =0;
			System.out.println("tabledatarow--->"+tabledatarow);
			String a_xpath = "//table[@id='"+tableId+"']/tbody/tr[";
			String b_xpath = "]/td["+tableColumnIndex+"]";
			// calculate rows number with size()
			int Count = 0;
			boolean jsTitleFound = false;
			do {
				int tSize = approvalTable.size();
				String celtxt = null;
				logger.info("current max table entries are ="+tSize);
				// iterate rows of table and check matching condition
				for (int i = 1; i <= tSize; i++) {
					System.out.println(i);
					String n = driver.findElement(By.xpath(a_xpath + i + b_xpath)).getText();
					//System.out.println("n----->"+n);
					if (n.contains(searchText)) {
						// get text of matching cell
						celtxt = driver.findElement(By.xpath("//*[@id='emailConfigTable']/tbody/tr[" + i + "]/td["+tableColumnIndex+"]")).getText();
						logger.info("The cell data at particular row is:"+celtxt);
						//System.out.println("The cell data at particular row is:"+celtxt);
						jsTitleFound = true;
						break;
					}
				}
				if (jsTitleFound == false) {
					System.out.println(jsTitleFound);
					driver.findElement(By.xpath("//*[@id=\"DyanmicTable01_next\"]/a")).click();
					System.out.println("Table - checking Next 10 entries");
					Count = Count + 10;
					System.out.println(Count);
				}
				if (jsTitleFound == true) {
					break;
				}
			} while (Count < tabledatarowdumy);
			logger.info("completed");
			//Log.info("TC2_Swades_Edit_Jobsheet |completed");
			//writeXLSXExcel_ColumnNumber(SSF, sheetName, xlsxLastRowNum, 1, "Pass");
		} catch (Exception e) {
			logger.error("Exception :- " + e);
		}
	}

}
