package es.neesis.ahorcado.enums;

import java.util.List;

public enum PalabrasEnum {
    BUENO("bueno"),
    MALO("malo"),
    REGULAR("regular"),
    EXCELENTE("excelente"),
    PESIMO("pesimo"),
    BONITO("bonito"),
    BARATO("barato"),
    VANADIO("vanadio"),
    CROMO("cromo"),
    MANGANESO("manganeso"),
    HIERRO("hierro"),
    COBALTO("cobalto"),
    NIQUEL("nickel"),
    COBRE("cobre"),;

    private final String palabra;

    private PalabrasEnum(String palabra) {
        this.palabra = palabra;
    }

    public List<String> getAsList() {
        return List.of(palabra.split(""));
    }

}
