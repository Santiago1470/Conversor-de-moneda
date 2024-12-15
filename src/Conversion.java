import java.util.*;

public class Conversion {
    int id;
    Date fechaConversion;
    String monedaBase;
    String monedaDestino;
    double tasaConversion;
    double valorBase;
    double resultado;

    public Conversion() {

    }

    public Conversion(int id, Date fechaConversion, String monedaBase, String monedaDestino,
                      double tasaConversion, double valorBase, double resultado) {
        this.id = id;
        this.fechaConversion = fechaConversion;
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.tasaConversion = tasaConversion;
        this.valorBase = valorBase;
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format(Locale.US, """
                Conversión: %d
                Fecha: %s
                Moneda base: %s
                Moneda destino: %s
                Tasa de conversión: %.2f
                Valor base: %.2f
                Resultado de la conversión: %.2f
                """,
                this.id, this.fechaConversion, this.monedaBase,
                this.monedaDestino, this.tasaConversion, this.valorBase, this.resultado);
    }
}
