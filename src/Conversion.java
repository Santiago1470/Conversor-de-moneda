import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class Conversion {
    Date fechaConversion;
    String monedaBase;
    String monedaDestino;
    float tasaConversion;
    float resultado;
    Map<String, Float> tasaConversiones;

    public Conversion() {

    }

    public Conversion(Date fechaConversion, String monedaBase, String monedaDestino,
                      float tasaConversion, float resultado, Map<String, Float> tasaConversiones) {
        this.fechaConversion = fechaConversion;
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.tasaConversion = tasaConversion;
        this.resultado = resultado;
        this.tasaConversiones = tasaConversiones;
    }

    public Conversion(Date fechaConversion, String monedaBase,
                      String monedaDestino, float tasaConversion, float resultado) {
        this.fechaConversion = fechaConversion;
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.tasaConversion = tasaConversion;
        this.resultado = resultado;
    }

    public Date getFechaConversion() {
        return fechaConversion;
    }

    public void setFechaConversion(Date fechaConversion) {
        this.fechaConversion = fechaConversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public float getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(float tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public Map<String, Float> getTasaConversiones() {
        return tasaConversiones;
    }

    public void setTasaConversiones(Map<String, Float> tasaConversiones) {
        this.tasaConversiones = tasaConversiones;
    }
}
