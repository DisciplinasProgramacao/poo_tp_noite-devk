package codigo;

/**
 * Enumeração de gêneros disponíveis para as mídias
 */
public enum Genero {
    /**
    * Tipos de Gêneros
    */
    ACAO("Ação"),
    ANIME("Anime"),
    AVENTURA("Aventura"),
    COMEDIA("Comédia"),
    DOCUMENTARIO("Documentário"),
    DRAMA("Drama"),
    POLICIAL("Policial"),
    ROMANCE("Romance"),
    SUSPENSE("Suspense");
    /**
    * Nome gênero
    */
    private String genero;

    /**
    * Construtor
    * @param nome do gênero
    */
    Genero (String genero){
        this.genero = genero;
    }

    /**
    * Getter
    * return gênero
    */
    public String getGenero() {
        return genero;
    }
    /**
    * Descobre se o gênero está disponível
    * @param genero nome do gênero para procurar
    */
    public static Genero descobreGenero(String genero) {
        return Genero.valueOf(genero.toUpperCase()); 
    }
   
}



