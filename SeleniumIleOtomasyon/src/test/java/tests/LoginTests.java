package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sayfalar.AnaSayfa;
import sayfalar.GirisYapSayfasi;

public class LoginTests {

    private WebDriver driver;
    private AnaSayfa anaSayfa;
    private GirisYapSayfasi girisYapSayfasi;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        anaSayfa = new AnaSayfa(driver);
        girisYapSayfasi = new GirisYapSayfasi(driver);
        driver.get("https://www.hepsiburada.com");
    }

    @Test
    void hepsiburadaLoginTesti() {

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("myAccount")));
        anaSayfa.elementGozukeneKadarBekle(anaSayfa.hesabim);
        //driver.findElement(By.id("myAccount")).click();
        anaSayfa.tusaBas(anaSayfa.hesabim);

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        anaSayfa.elementGozukeneKadarBekle(anaSayfa.girisYap);
        //driver.findElement(By.id("login")).click();
        anaSayfa.tusaBas(anaSayfa.girisYap);

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUserName")));
        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.emailAdresi);
        //driver.findElement(By.id("txtUserName")).sendKeys("seleniumOtomasyonu@gmail.com");
        girisYapSayfasi.alanaYaziYaz(girisYapSayfasi.emailAdresi,"seleniumOtomasyonu@gmail.com");

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.girisYapTusu);
        //driver.findElement(By.id("btnLogin")).click();
        girisYapSayfasi.tusaBas(girisYapSayfasi.girisYapTusu);
    }

    @Test
    void urunAramaTest(){
        anaSayfa.elementGozukeneKadarBekleCss(anaSayfa.urunArama);
        anaSayfa.alanaYaziYazCss(anaSayfa.urunArama, "Araba");
        anaSayfa.klavyeTusunaBas(anaSayfa.urunArama, Keys.ENTER);
    }

    @AfterEach
    void tearDown(){
        driver.close();
    }

}
