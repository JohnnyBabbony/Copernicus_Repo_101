import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.url) // opens web browser and profile url is ised here.

WebUI.maximizeWindow() // pretty self explainatory



// click for login, on home page


// ctrl + f, in developer mode in browser. Locate by CSS - div[class="usermenu"]
// it's about finding way to select correct element in the html code

// it's Xpath I guess, so we can do next div[class="usermenu"]>span>a    (we go "down" two elements span, a href. Where div class = usermenu)

// div[class="usermenu"]>span>a       // in our test case, this Xpath locates the login button, in universal way.

// if we have id atribute in html, use it for locating objects on the page.

WebUI.click(findTestObject('Object Repository/Elearning_objects/HomePage_login_button')) 


// setting up the username and password fields with added prior saved variables 

WebUI.setText(findTestObject('Object Repository/Elearning_objects/Username_field'), username)

WebUI.setText(findTestObject('Object Repository/Elearning_objects/Password_field'), pwd)


// click 

WebUI.click(findTestObject('Object Repository/Elearning_objects/LoginPage_login_button'))


// error message test
// we add expected value to tmp_variable

String element_error_message = WebUI.getText(findTestObject('Object Repository/Elearning_objects/LoginErrorMessage'))

// comparing saved error_msg variable to getText value from actual web response
assert error_msg == element_error_message

WebUI.closeBrowser()
