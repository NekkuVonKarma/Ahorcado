package es.neesis.ahorcado.applications;

import es.neesis.ahorcado.services.IAhorcadoService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AhorcadoApp {
    private final IAhorcadoService ahorcadoService;

    public AhorcadoApp(IAhorcadoService ahorcadoService) {
        this.ahorcadoService = ahorcadoService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Boolean seguirJugando = true;
        this.mostrarCabecera();

        while (seguirJugando) {
            this.ahorcadoService.inicializarPartida();

            while (!this.ahorcadoService.isPartidaFinalizada()) {
                this.mostrarPartida();
                this.jugar(scanner);
            }

            this.mostrarPartida();
            seguirJugando = mostrarCierre(scanner);
        }
    }

    private void mostrarCabecera() {
        System.out.println("Bienvenido al juego del ahorcado");
    }

    private void jugar(Scanner scanner) {
        System.out.println("Introduce una letra: ");
        String letra = scanner.nextLine();
        this.ahorcadoService.jugar(letra);
    }

    private void mostrarPartida() {
        System.out.println("=================================");
        System.out.println("Intentos restantes: " + this.ahorcadoService.getIntentosRestantes());
        System.out.println("Palabra: " + this.ahorcadoService.getPalabraActual());
    }

    private Boolean mostrarCierre(Scanner scanner) {
        Boolean seguirJugando;
        if (this.ahorcadoService.isPartidaGanada()) {
            System.out.println("¡Enhorabuena! Has ganado");
        } else {
            System.out.println("¡Lo siento! Has perdido");
        }
        System.out.println("¿Quieres jugar otra partida? (s/n)");
        seguirJugando = scanner.nextLine().equalsIgnoreCase("s");
        return seguirJugando;
    }
}
