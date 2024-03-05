package es.neesis.ahorcado.services;

public interface IAhorcadoService {

    void inicializarPartida();

    void jugar(String input);

    Integer getIntentosRestantes();

    String getPalabraActual();

    Boolean isPartidaFinalizada();

    Boolean isPartidaGanada();

}
