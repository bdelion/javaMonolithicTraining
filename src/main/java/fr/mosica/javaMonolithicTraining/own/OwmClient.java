package fr.mosica.javaMonolithicTraining.own;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author florent
 */
public class OwmClient {
    
    private static final Logger LOG = LogManager.getLogger(OwmClient.class);
    
    /**
     * URL du serveur
     */
    private URL ownUrl;
    
    private ObjectMapper jsonMapper;
    
    public OwmClient(URL ownUrl){
        this.ownUrl = ownUrl;
        this.jsonMapper = new ObjectMapper();
        this.jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    
    /**
     * 
     * @return 
     */
    public WeatherResult getWeather(){
        try {
            HttpURLConnection ownConnexion = (HttpURLConnection) ownUrl.openConnection();
            
            ownConnexion.connect();
            if (ownConnexion.getResponseCode() != 200) {
                throw new TechnicalException("Statut invalide "+ownConnexion.getResponseCode());
            }
            
            return this.jsonMapper.readValue(ownConnexion.getInputStream(), WeatherResult.class);
        } catch (IOException ex) {
            throw new TechnicalException("Impossible de contacter OWN", ex);
        }
    }

    public URL getOwnUrl() {
        return ownUrl;
    }

    public ObjectMapper getJsonMapper() {
        return jsonMapper;
    }

    public void setJsonMapper(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    public WeatherResult getWeather(String CP) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + CP + ",fr&APPID=8c05dfed7d5d0d8ba3a2bc70b83b227f";
        
        // déclarations de variables locales
        WeatherResult weatherResult = null;
        HttpURLConnection owmConnection = null;

        //lire le flux et le convertir en objet
        try {
            URL owmUrl = new URL(url);
            owmConnection = (HttpURLConnection) owmUrl.openConnection();
            // sortie en erreur si le code retour est KO <>200
            if (owmConnection.getResponseCode() != 200) {
                throw new TechnicalException("Statut de la réponse invalide (code retour = '" + owmConnection.getResponseCode() + "' / message = '" + owmConnection.getResponseMessage() + "')");
            }
            // pour avoir une sortie structurée du flux : http://json.parser.online.fr/
            weatherResult = this.jsonMapper.readValue(owmConnection.getInputStream(), WeatherResult.class);
        } catch (MalformedURLException ex) {
            throw new TechnicalException("Oups ! Pb sur l'URL", ex);
        } catch (IOException ex) {
            throw new TechnicalException("Oups ! I/O erreur", ex);
        } finally {
            if (owmConnection != null) {
                owmConnection.disconnect();
            }
        }
        return weatherResult;
    }
    
    
    
}
