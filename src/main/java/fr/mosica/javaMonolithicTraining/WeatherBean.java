package fr.mosica.javaMonolithicTraining;

import fr.mosica.javaMonolithicTraining.own.OwmClient;
import fr.mosica.javaMonolithicTraining.own.TechnicalException;
import fr.mosica.javaMonolithicTraining.own.WeatherResult;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

@ManagedBean
@SessionScoped
public class WeatherBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String localite;
    private String codePostal;
    private String temperature;
    private String vitesseVent;

    public String getResult() {
        // déclaration service météo
        OwmClient owmc = new OwmClient(null);
        try {
            // appel au service de météo
            WeatherResult cpWeather = owmc.getWeather(codePostal);

            localite = cpWeather.getName();
            temperature = String.format("%.2f °C", cpWeather.getMain().getTemp() - 273.15);
            vitesseVent = String.format("%.2f m/sec", cpWeather.getWind().getSpeed());
        } catch (TechnicalException te) {
            te.printStackTrace(System.err);
        }

        return "welcome";
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVitesseVent() {
        return vitesseVent;
    }

    public void setVitesseVent(String vitesseVent) {
        this.vitesseVent = vitesseVent;
    }
    
    
}
