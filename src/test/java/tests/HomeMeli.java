package tests;


import base.BaseTests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

//@Listeners({ExtentITestListenerClassAdapter.class})
@Listeners({ExtentITestListenerAdapter.class})

public class HomeMeli extends BaseTests {

    @Test(dataProvider = "Authentication",groups = { "pagePrincipal", "t:producto", "a:Alejandro", "d: Windows 10" })
    public void busquedaDeProducto(String product, String caso) throws InterruptedException {

        homeMeli.searched(product);

        assertTrue(true);
        Thread.sleep(3333);

       }


    @Test(groups = { "cord", "t:titu", "a:Bruno", "d: Windows 10" })
    public void titulo(){

         assertTrue(homeMeli.homeTitulo().contains("Mercado"),"El titulo no contiene 'Mercado' " );

    }




}
