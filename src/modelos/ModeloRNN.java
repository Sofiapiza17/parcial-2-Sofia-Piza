package modelos;

import datos.Dataset;

/**
 * Modelo RNN. Hiperparámetro: número de capas.
 */
public class ModeloRNN extends Modelo {

    private int numCapas;

    public ModeloRNN(String nombre, int maxEpocas, int numCapas) {
        super(nombre, maxEpocas);
        this.numCapas = numCapas;
    }

    @Override
    public double entrenar(Dataset dataset) {
        for (int i = 0; i < getMaxEpocas(); i++) {
            registrarEpoca(10 - i);
        }
        return mejorLoss();
    }

    public int getNumCapas() { return numCapas; }
}
