package plataforma;

import datos.Dataset;
import modelos.*;

/**
 * Clase que representa un experimento de Machine Learning.
 */
public class Experimento {

    private final String id;
    private final Modelo modelo;

    public Experimento(String id, String tipoModelo, int maxEpocas) {
        this.id = id;
        if ("CNN".equalsIgnoreCase(tipoModelo)) {
            this.modelo = new ModeloCNN("CNN", maxEpocas, 16);
        } else if ("RNN".equalsIgnoreCase(tipoModelo)) {
            this.modelo = new ModeloRNN("RNN", maxEpocas, 2);
        } else if ("REGRESION".equalsIgnoreCase(tipoModelo)) {
            this.modelo = new ModeloRegresion("REGRESION", maxEpocas, 1);
        } else {
            this.modelo = null;
        }
    }

    /**
     * Ejecuta el entrenamiento del modelo sobre el dataset.
     */
    public double ejecutar(Dataset dataset) {
        if (this.modelo == null || dataset == null) {
            return 0.0;
        }
        double loss = this.modelo.entrenar(dataset);
        return loss > 0 ? loss : 1.0;
    }

    public String getId() {
        return id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public double mejorLoss() {
        if (this.modelo != null) {
            return this.modelo.mejorLoss();
        }
        return Integer.MAX_VALUE;
    }
}
