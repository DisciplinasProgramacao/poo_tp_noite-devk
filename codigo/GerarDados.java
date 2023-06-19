package codigo;

import java.util.Random;

public class GerarDados {
    public static Genero obterGeneroAleatorio() {
        return Genero.values()[new Random().nextInt(Genero.values().length)];
    }

    public static Idioma obterIdiomaAleatorio() {
        return Idioma.values()[new Random().nextInt(Idioma.values().length)];
    }
}
