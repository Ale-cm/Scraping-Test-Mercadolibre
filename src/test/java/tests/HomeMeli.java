package tests;

import base.BaseTests;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HomeMeli extends BaseTests {

    @Test ()
    public void busquedaDeProducto(){
         ExtentTest test = extent.createTest("Busqueda de un producto","Se realiza la busqueda de un producto");
         test.log(Status.INFO, " hola jovenes" );
        String product = "zapatillas";
        homeMeli.searched(product);
        test.info("detallitos aver si sale", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());


        test.info("Se coloco el producto "+ product+ "en el cuadro de busqueda");
        assertEquals(homeMeli.searchOferta(),"Ofertas","No aparece el nombre");
        test.pass("Encontro la palabra Oerta");
        test.info("Todo correcto bro");

        test.log(Status.INFO, " hola " );
    }


    @Test ()
    public void titulo(){

        ExtentTest test = extent.createTest(" de un producto","Se realiza la busqueda de un producto");
        test.log(Status.INFO, " hola jovenes" );
         assertTrue(homeMeli.homeTitulo().contains("Mercado"));

    }


}
