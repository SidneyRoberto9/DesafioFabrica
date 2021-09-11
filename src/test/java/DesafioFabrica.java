import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DesafioFabrica {
    private WebDriver driver;

    @Before
    public void inicializar(){
        System.setProperty("webdriver.gecko.driver", "C:/Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
    }

    @After
    public void finalizar(){
       driver.quit();
    }

    @Test
    public void PrimeiroTest(){
        //Nome e Senha
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[1]/td/input")).sendKeys("nome");
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[2]/td/input")).sendKeys("senha");

        //Comentário
        WebElement comment = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea"));
        comment.clear();
        comment.sendKeys("Comentei e sai correndo.");

        //CheckBox
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]")).click();

        //Radio Items
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[2]")).click();

        //Multiple Select values
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select/option[4]"));

        //Dropdown
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[8]/td/select/option[6]")).click();

        //Submit
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]")).click();

        //validation
        Assert.assertEquals("nome", driver.findElement(By.xpath("//*[@id=\"_valueusername\"]")).getText());
        Assert.assertEquals("senha", driver.findElement(By.xpath("//*[@id=\"_valuepassword\"]")).getText());
        Assert.assertEquals("Comentei e sai correndo.", driver.findElement(By.xpath("//*[@id=\"_valuecomments\"]")).getText());
        Assert.assertEquals("cb1", driver.findElement(By.xpath("//*[@id=\"_valuecheckboxes0\"]")).getText());
        Assert.assertEquals("cb2", driver.findElement(By.xpath("//*[@id=\"_valuecheckboxes1\"]")).getText());
        Assert.assertEquals("cb3", driver.findElement(By.xpath("//*[@id=\"_valuecheckboxes2\"]")).getText());
        Assert.assertEquals("rd2", driver.findElement(By.xpath("//*[@id=\"_valueradioval\"]")).getText());
        Assert.assertEquals("ms4", driver.findElement(By.xpath("//*[@id=\"_valuemultipleselect0\"]")).getText());
        Assert.assertEquals("dd6", driver.findElement(By.xpath("//*[@id=\"_valuedropdown\"]")).getText());
    }

    @Test
    public void SegundoTest(){
        //comentário
        WebElement comment = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[3]/td/textarea"));
        comment.clear();

        //Submit
        driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[9]/td/input[2]")).click();

        //validation
        Assert.assertEquals("No Value for username", driver.findElement(By.xpath("/html/body/div/div[3]/p[1]/strong")).getText());
        Assert.assertEquals("No Value for password", driver.findElement(By.xpath("/html/body/div/div[3]/p[2]/strong")).getText());
        Assert.assertEquals("No Value for comments", driver.findElement(By.xpath("/html/body/div/div[3]/p[3]/strong")).getText());
    }
}
