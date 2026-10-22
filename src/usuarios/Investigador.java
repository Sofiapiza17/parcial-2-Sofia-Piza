package usuarios;

import plataforma.Experimento;
import java.util.ArrayList;

/**
 * Investigador que se ASOCIA a varios experimentos (N:M).
 */
public class Investigador {

    private String nombre;
    private ArrayList<Experimento> experimentos;

    public Investigador(String nombre) {
        this.nombre = nombre;
        this.experimentos = new ArrayList<>();
    }

    public void asociarExperimento(Experimento experimento) {
        if (experimento != null) {
            boolean yaExiste = false;
            for (Experimento exp : this.experimentos) {
                if (exp.getId().equals(experimento.getId())) {
                    yaExiste = true;
                    break;
                }
            }
            if (!yaExiste) {
                this.experimentos.add(experimento);
            }
        }
    }

    public String getNombre() { return nombre; }
    public ArrayList<Experimento> getExperimentos() { return experimentos; }
}