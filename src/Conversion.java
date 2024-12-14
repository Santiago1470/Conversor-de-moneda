import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class Conversion {
    Date fechaConversion;
    String monedaBase;
    String monedaDestino;
    double tasaConversion;
    double valorBase;
    double resultado;
    Map<String, Double> tasaConversiones;

    public Conversion() {

    }

    public Conversion(Date fechaConversion, String monedaBase, String monedaDestino, double tasaConversion,
                      double valorBase, double resultado, Map<String, Double> tasaConversiones) {
        this.fechaConversion = fechaConversion;
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.tasaConversion = tasaConversion;
        this.valorBase = valorBase;
        this.resultado = resultado;
        this.tasaConversiones = tasaConversiones;
    }

    public Conversion(Date fechaConversion, String monedaBase, String monedaDestino,
                      double tasaConversion, double valorBase, double resultado) {
        this.fechaConversion = fechaConversion;
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.tasaConversion = tasaConversion;
        this.valorBase = valorBase;
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

    public double getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public Map<String, Double> getTasaConversiones() {
        return tasaConversiones;
    }

    public void setTasaConversiones(Map<String, Double> tasaConversiones) {
        this.tasaConversiones = tasaConversiones;
    }
}
