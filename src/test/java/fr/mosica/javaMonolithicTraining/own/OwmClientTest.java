/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mosica.javaMonolithicTraining.own;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author MOSICA
 */
public class OwmClientTest {

    @Rule
    // No-args constructor defaults to port 8080
    // 0 to dynamic port
    public WireMockRule wireMockRule = new WireMockRule(0);
    
    /**
     * Chemin de la ressource l'api current weather de OWN
     */
    private final static String WEATHER_API_PATH = "/current";
    
    /**
     * Mes tests.
     * @throws java.io.IOException
     */
    @Test
    public void testGetWeather_OK() throws IOException {
        (new WeatherStub(WEATHER_API_PATH, 200, "owm_current_niort_ok.json")).stub();
        
        OwmClient owmc = new OwmClient(new URL(
                "http://localhost:{port}{path}"
                .replace("{port}", String.valueOf(wireMockRule.port()))
                .replace("{path}", WEATHER_API_PATH)
        ));
        
        
        
                
//        (new WeatherStub(WEATHER_API_PATH, 200, "owm_weather_bessines_ok.json")).stub();
//        
//        OwmClient client = new OwmClient(
//            new URL(
//                "http://localhost:{port}{path}"
//                    .replace("{port}", String.valueOf(wireMockRule.port()))
//                    .replace("{path}", WEATHER_API_PATH)
//            )
//        );
//        
//        WeatherResult weatherResult = client.getWeather();
//        assertEquals("Bessines", weatherResult.getName()
//        );
//        // TODO il faut développer le test
        
//        stubFor(get(urlEqualTo("/current")).willReturn(
//                aResponse()
//                .withStatus(200)
//                .withHeader("Content-Type", "application/json")
//                .withBody(IOUtils.toByteArray(
//                        Thread.currentThread().getContextClassLoader().getResourceAsStream("owm_current_niort_ok.json")
//                ))
//        ));
//
//        System.out.println(wireMockRule.port());
//        System.out.println("=-=-=-=");
        

//        stubFor(get(urlEqualTo("/my/resource"))
//                .withHeader("Accept", equalTo("text/xml"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "text/xml")
//                        .withBody("<response>Some content</response>")));
//
//        Result result = myHttpServiceCallingObject.doSomething();
//
//        assertTrue(result.wasSuccessFul());
//
//        verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
//                .withRequestBody(matching(".*<message>1234</message>.*"))
//                .withHeader("Content-Type", notMatching("application/json")));
    }

//    /**
//     * Test of getWeather method, of class OwmClient.
//     */
//    @Test
//    public void testGetWeather_0args() {
//        System.out.println("getWeather");
//        OwmClient instance = null;
//        WeatherResult expResult = null;
//        WeatherResult result = instance.getWeather();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOwnUrl method, of class OwmClient.
//     */
//    @Test
//    public void testGetOwnUrl() {
//        System.out.println("getOwnUrl");
//        OwmClient instance = null;
//        URL expResult = null;
//        URL result = instance.getOwnUrl();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getJsonMapper method, of class OwmClient.
//     */
//    @Test
//    public void testGetJsonMapper() {
//        System.out.println("getJsonMapper");
//        OwmClient instance = null;
//        ObjectMapper expResult = null;
//        ObjectMapper result = instance.getJsonMapper();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setJsonMapper method, of class OwmClient.
//     */
//    @Test
//    public void testSetJsonMapper() {
//        System.out.println("setJsonMapper");
//        ObjectMapper jsonMapper = null;
//        OwmClient instance = null;
//        instance.setJsonMapper(jsonMapper);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getWeather method, of class OwmClient.
//     */
//    @Test
//    public void testGetWeather_String() {
//        System.out.println("getWeather");
//        String CP = "";
//        OwmClient instance = null;
//        WeatherResult expResult = null;
//        WeatherResult result = instance.getWeather(CP);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
