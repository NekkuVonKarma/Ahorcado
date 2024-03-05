package es.neesis.ahorcado.services;

import es.neesis.ahorcado.enums.PalabrasEnum;
import es.neesis.ahorcado.model.Partida;
import org.springframework.stereotype.Service;

@Service
public class AhorcadoService implements IAhorcadoService{

    private Partida partidaActual;

    @Override
    public void inicializarPartida() {
        this.partidaActual = new Partida();

        PalabrasEnum palabra = PalabrasEnum.values()[(int) (Math.random() * PalabrasEnum.values().length)];
        this.partidaActual.setPalabraResuelta(palabra.getAsList());
        this.partidaActual.ofuscarPalabraActual();
    }

    @Override
    public void jugar(String input) {
        if (this.partidaActual.getIntentosRestantes() > 0) {
            if (input.length() > 1) {
                if (String.join("", this.partidaActual.getPalabraResuelta()).equalsIgnoreCase(input)) {
                    this.partidaActual.setPalabraActual(this.partidaActual.getPalabraResuelta());
                } else {
                    this.partidaActual.decrementarIntentosRestantes();
                }
            } else {
                if (this.partidaActual.getPalabraResuelta().stream().anyMatch(input::equalsIgnoreCase)) {
                    this.partidaActual.actualizarPalabraActual(input);
                } else {
                    this.partidaActual.decrementarIntentosRestantes();
                }
            }
        }
    }

    @Override
    public Integer getIntentosRestantes() {
        return this.partidaActual.getIntentosRestantes();
    }

    @Override
    public String getPalabraActual() {
        return String.join(" ", this.partidaActual.getPalabraActual());
    }

    @Override
    public Boolean isPartidaFinalizada() {
        return this.partidaActual.getIntentosRestantes() == 0 || !this.partidaActual.getPalabraActual().contains("_");
    }

    @Override
    public Boolean isPartidaGanada() {
        return !this.partidaActual.getPalabraActual().contains("_");
    }
}
