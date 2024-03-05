package es.neesis.ahorcado.model;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private List<String> palabraResuelta;
    private List<String> palabraActual;
    private Integer intentosRestantes;

    public Partida() {
        this.palabraResuelta = new ArrayList<>();
        this.palabraActual = new ArrayList<>();
        this.intentosRestantes = 8;
    }

    public List<String> getPalabraResuelta() {
        return palabraResuelta;
    }

    public void setPalabraResuelta(List<String> palabraResuelta) {
        this.palabraResuelta = palabraResuelta;
    }

    public List<String> getPalabraActual() {
        return palabraActual;
    }

    public void setPalabraActual(List<String> palabraActual) {
        this.palabraActual = palabraActual;
    }

    public Integer getIntentosRestantes() {
        return intentosRestantes;
    }

    public void setIntentosRestantes(Integer intentosRestantes) {
        this.intentosRestantes = intentosRestantes;
    }

    public void ofuscarPalabraActual() {
        for (int i = 0; i < palabraResuelta.size(); i++) {
            palabraActual.add("_");
        }
    }

    public void decrementarIntentosRestantes() {
        this.intentosRestantes--;
    }

    public void actualizarPalabraActual(String letra) {
        for (int i = 0; i < palabraResuelta.size(); i++) {
            if (palabraResuelta.get(i).equals(letra)) {
                palabraActual.set(i, letra);
            }
        }
    }
}
