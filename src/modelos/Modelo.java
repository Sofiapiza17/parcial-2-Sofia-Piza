package modelos;

import datos.Dataset;
import servicios.MetricaEvaluacion;


/**
 * Clase abstracta que representa un modelo de ML genérico.
 * Mantiene un historial del loss por época en un arreglo de enteros.
 */
public abstract class Modelo {

    private String nombre;
    private int[] lossPorEpoca; // int[] obligatorio
    protected int epocaActual;
    protected int mejorLossRegistrado;
    private int maxEpocas;

    public Modelo(String nombre, int maxEpocas) {
        this.nombre = nombre;
        this.maxEpocas = maxEpocas;
        this.lossPorEpoca = new int[maxEpocas];
        this.epocaActual = 0;
        this.mejorLossRegistrado = Integer.MAX_VALUE;
    }

    /**
     * Cada subclase implementa cómo entrena sobre el dataset (polimorfismo).
     * Debe registrar las épocas y retornar el mejor loss alcanzado.
     */
    public abstract double entrenar(Dataset dataset);

    /**
     * Registra el loss de una época. Si el buffer se llena,
     * actualiza el mejor loss pero no agrega más elementos.
     */
    public void registrarEpoca(int loss) {
        if (this.epocaActual < this.maxEpocas) {
            this.lossPorEpoca[this.epocaActual] = loss;
        }
        this.epocaActual++;
        if (loss < this.mejorLossRegistrado) {
            this.mejorLossRegistrado = loss;
        }
    }

    /**
     * Retorna el mejor (menor) loss registrado.
     * Si no hay épocas, retorna Integer.MAX_VALUE.
     */
    public int mejorLoss() {
        if (this.epocaActual == 0) {
            return Integer.MAX_VALUE;
        }
        return this.mejorLossRegistrado;
    }

    /**
     * Usa MetricaEvaluacion como DEPENDENCIA puntual.
     * No se guarda como atributo.
     */
    public double calcularMetrica(MetricaEvaluacion metrica) {
        if (metrica == null) {
            return 0.0;
        }
        return 1.0;
    }
    // Getters encapsulados
    public String getNombre() { return nombre; }
    public int[] getLossPorEpoca() { return lossPorEpoca; }
    public int getEpocaActual() { return epocaActual; }
    public int getMejorLossRegistrado() { return mejorLossRegistrado; }
    public int getMaxEpocas() { return maxEpocas; }

    protected void setEpocaActual(int epocaActual) { this.epocaActual = epocaActual; }
    protected void setMejorLossRegistrado(int v) { this.mejorLossRegistrado = v; }
}