package codigo;

public class GerarDados {
    private static final String[] generos = { "Ação", "Anime", "Aventura", "Comédia", "Documentário",
            "Drama", "Policial", "Romance", "Suspense" };
    private static final String[] idiomas = { "Inglês", "Português", "Espanhol" };

    public static String obterGeneroAleatorio() {
        int indice = (int) Math.random() * idiomas.length;
        return GerarDados.generos[indice];
    }

    public static String obterIdiomaAleatorio() {
        int indice = (int) Math.random() * idiomas.length;
        return GerarDados.idiomas[indice];
    }
}
