import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import java.awt.*;
import java.util.concurrent.TimeUnit;

public class PreAssessment {
    private ChromeDriver chromeDriver;

    @Test
    public void hacer_una_busqueda() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette",false);
        options.addArguments("--start-maximized");
        chromeDriver = new ChromeDriver(options);
        chromeDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        chromeDriver.get("https://uat.mdforms.net/Account/Login?ReturnUrl=%2F");

        //LOGIN
        chromeDriver.findElement(By.xpath("//input[@id='Username']")).sendKeys("root");
        chromeDriver.findElement(By.xpath("//input[@id='Password']")).sendKeys("T3chn0l0gy9145#");
        chromeDriver.findElement(By.xpath("//body/div[3]/div[1]/div[2]/section[1]/form[1]/div[4]/div[1]/input[1]")).sendKeys(Keys.ENTER);
        Thread.sleep(200);

        //INGRESAR A FORMS

        WebElement ingresarForm = chromeDriver.findElement(By.xpath("//body/nav[@id='_SidepannelNavigationBar']/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]"));
        ingresarForm.click();
        chromeDriver.findElement(By.xpath("//li/a[contains(text(), 'New Form')]")).click();
        Thread.sleep(5000);

        // CREAR FORMS
        WebElement SeleccionarPaciente = chromeDriver.findElement(By.xpath("//span[@id='select2-PatientId-container']"));
        SeleccionarPaciente.click();
        Thread.sleep(200);
        WebElement EscribirNombreDePaciente = chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]"));
        EscribirNombreDePaciente.sendKeys("PACIENTE",Keys.ENTER);
        Thread.sleep(200);

        //Seleccionar formulario PRE ASSESSMENT
        WebElement Forms = chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/span[1]/span[1]/span[1]/span[2]/b[1]"));
        Forms.click();
        Actions accion = new Actions(chromeDriver);
        accion.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        Thread.sleep(200);

        //Seleccionar doctor
        WebElement Doctor = chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/span[1]/span[1]/span[1]/span[2]/b[1]"));
        Doctor.click();
        Actions seleccionar = new Actions(chromeDriver);
        seleccionar.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
        Thread.sleep(200);

        //Boton START
        WebElement Start = chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[1]/div[1]/div[1]/div[7]/input[1]"));
        Start.click();
        Thread.sleep(200);

        //INGRESAR DATOS A FORMULARIO PRE-ASSESSMENT
        //PRE-OP ORDERS
        chromeDriver.findElement(By.xpath("//input[@id='PreopNurshingLabsCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='IVAccessCheck']")).click();
        chromeDriver.findElement(By.cssSelector("#NSCheck")).click();
        chromeDriver.findElement(By.cssSelector("#NSRate")).sendKeys("25");
        chromeDriver.findElement(By.cssSelector("#D5Check")).click();
        chromeDriver.findElement(By.cssSelector("#D5Rate")).sendKeys("80");
        chromeDriver.findElement(By.cssSelector("#SalineLockCheck")).click();
        chromeDriver.findElement(By.cssSelector("#PreopLabsCheck")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PreopMedsCheck']")).click();
        Thread.sleep(6000);
            //AGREGAR MEDICAMENTOS
        WebElement AddMedications = chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/a[1]/i[1]"));
        AddMedications.click();

        WebElement Classification = chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]/span[2]/b[1]"));
        Classification.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("OTHER ME", Keys.ENTER);
        Thread.sleep(6000);

        WebElement Medication = chromeDriver.findElement(By.xpath("//span[@id='select2-Medication-container']"));
        Medication.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("AS OR", Keys.ENTER);
        Thread.sleep(6000);
        //Colocar PIN
        chromeDriver.findElement(By.xpath("//input[@id='btnAddNewRow']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePinForMedication1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButtonForMedication']")).click();
        Thread.sleep(6000);

            //AGREGAR 2DO MEDICAMENTO
        chromeDriver.findElement(By.xpath("//tbody/tr[@id='medicationRow1']/td[7]/a[3]/i[1]")).click();
        WebElement Classification2 = chromeDriver.findElement(By.xpath("//span[@id='select2-Classification-container']"));
        Classification2.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("antibiotic", Keys.ENTER);
        Thread.sleep(6000);
        WebElement Medication2 = chromeDriver.findElement(By.xpath("//span[@id='select2-Medication-container']"));
        Medication2.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("lasix", Keys.ENTER);
        Thread.sleep(6000);
        WebElement Amount2 = chromeDriver.findElement(By.xpath("//input[@id='MedicationAmount']"));
        Amount2.sendKeys("24");
        Thread.sleep(6000);
        WebElement Route2 = chromeDriver.findElement(By.xpath("//select[@id='Route']"));
        Route2.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

            //Colocar PIN Medicamento 2
        chromeDriver.findElement(By.xpath("//input[@id='btnAddNewRow']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePinForMedication1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButtonForMedication']")).click();
        Thread.sleep(6000);

            //AGREGAR 3ER MEDICAMENTO
        chromeDriver.findElement(By.xpath("//tbody/tr[@id='medicationRow2']/td[7]/a[3]/i[1]")).click();
        WebElement Classification3 = chromeDriver.findElement(By.xpath("//span[@id='select2-Classification-container']"));
        Classification3.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("antimetic", Keys.ENTER);
        Thread.sleep(6000);

        WebElement Medication3 = chromeDriver.findElement(By.xpath("//span[@id='select2-Medication-container']"));
        Medication3.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("Zofran", Keys.ENTER);
        Thread.sleep(6000);
        WebElement Amount3 = chromeDriver.findElement(By.xpath("//input[@id='MedicationAmount']"));
        Amount3.sendKeys("100");
        Thread.sleep(6000);
        WebElement Route3 = chromeDriver.findElement(By.xpath("//select[@id='Route']"));
        Route3.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(6000);
            //Colocar PIN Medicamento 3
        chromeDriver.findElement(By.xpath("//input[@id='btnAddNewRow']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePinForMedication1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButtonForMedication']")).click();
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(6000);

        //INTRA-OP ORDERS
        chromeDriver.findElement(By.xpath("//b[contains(text(),'INTRA-OP Orders')]")).click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//input[@id='PreopNursingCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='IntraPreopNursingCheck']")).click();
        chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/div[4]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/a[1]/i[1]")).click();
        Thread.sleep(6000);

         //Agregar 1er Medicamento
        WebElement ClasificacionIntra = chromeDriver.findElement(By.xpath("//span[@id='select2-Classification-container']"));
        ClasificacionIntra.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("OTHER ", Keys.ENTER);
        Thread.sleep(6000);
        WebElement MedicationIntra = chromeDriver.findElement(By.xpath("//span[@id='select2-Medication-container']"));
        MedicationIntra.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("AS ORD",Keys.ENTER);
        Thread.sleep(6000);
            //Ingresar PIN
        chromeDriver.findElement(By.xpath("//input[@id='btnIntraOPAddNewRow']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePinForMedication1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButtonForMedication']")).click();
        Thread.sleep(6000);

            //Agregar 2do Medicamento
        chromeDriver.findElement(By.xpath("//tbody/tr[@id='intraOPMedicationRow1']/td[7]/a[3]/i[1]")).click();
        Thread.sleep(6000);
        WebElement ClasificacionIntra2 = chromeDriver.findElement(By.xpath("//span[@id='select2-Classification-container']"));
        ClasificacionIntra2.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("antimetic", Keys.ENTER);
        Thread.sleep(6000);

        WebElement MedicationIntra2 = chromeDriver.findElement(By.xpath("//span[@id='select2-Medication-container']"));
        MedicationIntra2.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("Zofran",Keys.ENTER);
        Thread.sleep(6000);

        WebElement AmountIntra2 = chromeDriver.findElement(By.xpath("//input[@id='MedicationAmount']"));
        AmountIntra2.sendKeys("300");

        WebElement RouteIntra2 = chromeDriver.findElement(By.xpath("//select[@id='Route']"));
        RouteIntra2.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(6000);
            //Ingresar PIN
        chromeDriver.findElement(By.xpath("//input[@id='btnIntraOPAddNewRow']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePinForMedication1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButtonForMedication']")).click();
        Thread.sleep(6000);

        //POST OP ORDERS
        chromeDriver.findElement(By.xpath("//b[contains(text(),'POST-OP Orders')]")).click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderNursingCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderOther']")).sendKeys("150");
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderVascularCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderVenousCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderArterialCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderProtamineCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderOtherInstructionsText']")).sendKeys("800");
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderHemostasisCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderClosureCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderFiveFrenchCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderSevenFrenchCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderFourFrenchCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderSixFrenchCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderTenFrenchCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderClosureCheck1']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderOtherClosureText']")).sendKeys("800");
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PostOpStandingOrderPostopVascularCheck']")).click();
        Thread.sleep(6000);
        //Agregar 1er Medicamento
        chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/div[5]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]/a[1]/i[1]")).click();
        WebElement ClassificationOrder = chromeDriver.findElement(By.xpath("//span[@id='select2-Classification-container']"));
        ClassificationOrder.click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("OTHER MEDICATION", Keys.ENTER);

        WebElement MedicationOrder = chromeDriver.findElement(By.xpath("//span[@id='select2-Medication-container']"));
        MedicationOrder.click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("AS", Keys.ENTER);

        //Colocar PIN
        chromeDriver.findElement(By.xpath("//input[@id='btnPostOPAddNewRow']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePinForMedication1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButtonForMedication']")).click();
        Thread.sleep(6000);

        //Agregar 2do Medicamento
        chromeDriver.findElement(By.xpath("//tbody/tr[@id='postOPMedicationRow1']/td[7]/a[3]/i[1]")).click();
        WebElement ClassificationOrder2 = chromeDriver.findElement(By.xpath("//span[@id='select2-Classification-container']"));
        ClassificationOrder2.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("Antibioti", Keys.ENTER);
        Thread.sleep(6000);

        WebElement MedicationOrder2 = chromeDriver.findElement(By.xpath("//span[@id='select2-Medication-container']"));
        MedicationOrder2.click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("Lasix", Keys.ENTER);
        Thread.sleep(6000);

        WebElement AmountOrder2 = chromeDriver.findElement(By.xpath("//input[@id='MedicationAmount']"));
        AmountOrder2.sendKeys("300");
        Thread.sleep(6000);

        WebElement RouteOrder2 = chromeDriver.findElement(By.xpath("//select[@id='Route']"));
        RouteOrder2.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(6000);
        //Ingresar PIN
        chromeDriver.findElement(By.xpath("//input[@id='btnPostOPAddNewRow']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePinForMedication1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButtonForMedication']")).click();
        Thread.sleep(6000);

        //PATIENT CONSENT
        chromeDriver.findElement(By.xpath("//b[contains(text(),'Patient Consent')]")).click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentLeftCardiacCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentRightCardiacCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentLeftRightCardiacCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentRenalCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentAngioplastyCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentAbdominalCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentVenogramCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentRenalAngioCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentCarotidCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//select[@id='PatientConsentExtremity']")).sendKeys("Left Lower Extremity", Keys.ENTER);
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentOtherCheck']")).click();
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentOtherText']")).sendKeys("1500");
        Thread.sleep(6000);
        //Consentimiento de Paciente
        chromeDriver.findElement(By.xpath("//select[@id='ConsentNurseIdDropdown']")).sendKeys("Albert Diaz", Keys.ENTER);
        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//input[@id='ValidateNursePin1']")).sendKeys("1202");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateNurseButton']")).click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//select[@id='PatientConsentAnesthesiaMethod']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//input[@id='IAgreeSignature']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentInitials1']")).sendKeys("SC");
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentInitials2']")).sendKeys("SC");
        chromeDriver.findElement(By.xpath("//span[@id='select2-OnlyAddreess-container']")).click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("adv", Keys.ENTER);
        chromeDriver.findElement(By.xpath("//span[@id='select2-DoctorProcedure-container']")).click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("AB", Keys.ENTER);
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentInitials3']")).sendKeys("SC");
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentDate4']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentInitials6']")).sendKeys("SC");
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentInitials4']")).sendKeys("SC");
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//input[@id='PatientRelationship']")).sendKeys("father");
        chromeDriver.findElement(By.xpath("//input[@id='PatientReasonConsentWitness1']")).sendKeys("father");
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentWitness1']")).sendKeys("father");
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentWitness2']")).sendKeys("Mother");
        chromeDriver.findElement(By.xpath("//input[@id='PatientConsentDate2']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PatientWitnessConsentDate2']")).click();
        Thread.sleep(6000);

        //PREGNANCY STATEMENT
        chromeDriver.findElement(By.xpath("//label[contains(text(),'Pregnancy Statement')]")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyNotPregnantCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyMenopauseCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyDepoproveraCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyHysterectomyCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyMaleCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyAbstinenceCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyAbstinenceTimes']")).sendKeys("20");
        chromeDriver.findElement(By.xpath("//input[@id='PregnancySameSexPartnerCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyVasectomyCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyIntrauterineDeviceCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyTubalCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyAbstinenceCheck1']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyAbstinenceCheck2']")).click();
        Thread.sleep(6000);

        //ADMISSION ASSESSMENT
        chromeDriver.findElement(By.xpath("//b[contains(text(),'Admission Assessment')]")).click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//input[@id='ChecklistYesCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='ConsentNoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='InstructionsNaCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='HistoryNoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='AllergiesYesCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='NPONoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='VoidedNaCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='PregnancyNoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='DenturesYesCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='ChangeNoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='LabsNaCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='DiabeticNoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='InsulinYesCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='MetforminNoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='HomeNaCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='BloodNoCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='O2YesCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='ReviewedNoCheck']")).click();
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//span[@id='select2-BloodThinnerMedicationName-container']")).click();
        chromeDriver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("morp", Keys.ENTER);
        chromeDriver.findElement(By.xpath("//select[@id='ReviewedBy']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        Thread.sleep(6000);
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionPlatelet']")).sendKeys("1");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionHemoglobin']")).sendKeys("2");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionHematocrit']")).sendKeys("3");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionKplus']")).sendKeys("4");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionCreat']")).sendKeys("5");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionBun']")).sendKeys("6");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionGFR']")).sendKeys("7");
        Thread.sleep(6000);
        //IV
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionGauge']")).sendKeys("8");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionSite']")).sendKeys("9");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionLOC']")).sendKeys("5");
        Thread.sleep(6000);
        //RIGTH PULSE
        chromeDriver.findElement(By.xpath("//select[@id='RightAdmissionPulseSide']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//select[@id='RightAdmissionPulseLocation']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//select[@id='RightAdmissionPain']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        //LEFT PULSE
        chromeDriver.findElement(By.xpath("//select[@id='LeftAdmissionPulseSide']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//select[@id='LeftAdmissionPulseLocation']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//select[@id='LeftAdmissionPain']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        //IMMEDIATE PRE-OP EVALUATION BY SURGEON
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionHPUpdatedCheck']")).click();
        chromeDriver.findElement(By.xpath("//select[@id='AdmissionChanges']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//select[@id='AdmissionASAClass']")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
        //PHYSICAN NAME
        chromeDriver.findElement(By.xpath("//select[@id='PhysicianName']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionHLDelegatedCheck']")).click();
        //HEART
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionHeartWNLCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionLungsWNLCheck']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionHeartOther']")).sendKeys("500");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionLungsOther']")).sendKeys("300");
        chromeDriver.findElement(By.xpath("//textarea[@id='AdmissionComments']")).sendKeys("NO HAY COMENTARIOS");
        chromeDriver.findElement(By.xpath("//input[@id='AdmissionDateTime']")).click();
        Thread.sleep(6000);
        //PRE VITALS RECORDS
        chromeDriver.findElement(By.xpath("//select[@id='ddlSelectedRoom']")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        chromeDriver.findElement(By.xpath("//b[contains(text(),'PRE-Vitals Records')]")).click();
        Thread.sleep(6000);
            //Agregar 1er VITAL
            chromeDriver.findElement(By.xpath("//body/div[4]/form[1]/div[2]/div[9]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/i[1]")).click();
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//input[@id='getInitialInstantVitalsCpture']")).click();
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//tbody/tr[@id='rowPreVital1']/td[1]/a[1]/i[1]")).click();
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//input[@id='getInstantVitalsCpture']")).click();
            Thread.sleep(6000);
            chromeDriver.findElement(By.xpath("//input[@id='Time1']")).click();
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//input[@id='BP1']")).sendKeys("1");
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//input[@id='HR1']")).sendKeys("2");
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//input[@id='SPO21']")).sendKeys("3");
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//select[@id='RR1']")).sendKeys(" - Select RR -", Keys.ENTER);
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//select[@id='RR1']")).sendKeys("1", Keys.ENTER);
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//select[@id='Airway1']")).sendKeys("N/A", Keys.ENTER);
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//select[@id='Pain1']")).sendKeys("1/10", Keys.ENTER);
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//input[@id='PreTimes1']")).click();
            Thread.sleep(3000);
            chromeDriver.findElement(By.xpath("//tbody/tr[@id='rowPreVital1']/td[10]/input[3]")).click();
            Thread.sleep(8000);
            chromeDriver.findElement(By.xpath("//select[@id='notesId']")).sendKeys("Patient check in", Keys.ENTER);
            Thread.sleep(8000);
            chromeDriver.findElement(By.xpath("//tbody/tr[2]/td[1]/center[1]/input[1]")).click();
            Thread.sleep(8000);
            //Agregar Segundo Vitals
            chromeDriver.findElement(By.xpath("//tbody/tr[@id='rowPreVital1']/td[10]/a[3]/i[1]")).click();


        //FIRMAS DE ENFERMERA
        chromeDriver.findElement(By.xpath("//input[@id='nursesign']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='ValidateNursePin1']")).sendKeys("1203");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateNurseButton']")).click();

        //FIRMA DE DOCTOR
        chromeDriver.findElement(By.xpath("//input[@id='physiciansign']")).click();
        chromeDriver.findElement(By.xpath("//input[@id='validatePin1']")).sendKeys("1201");
        chromeDriver.findElement(By.xpath("//button[@id='ValidateButton']")).click();


    }
}
