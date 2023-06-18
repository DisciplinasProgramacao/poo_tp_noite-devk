package codigo;

import java.util.Random;

public class GerarDados {
    private static final String[] idiomas = { "Inglês", "Português", "Espanhol" };

    public static Genero obterGeneroAleatorio() {
        return Genero.values()[new Random().nextInt(Genero.values().length)];
    }

    public static String obterIdiomaAleatorio() {
        int indice = (int) Math.random() * idiomas.length;
        return GerarDados.idiomas[indice];
    }
}
