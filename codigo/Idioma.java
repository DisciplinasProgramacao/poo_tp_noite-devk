package codigo;

/**
 * Enumeração de idiomas disponíveis para as mídias
 */
public enum Idioma {
    /**
    * Tipos de idiomas 
    */
    PORTUGUES("Português"),
    INGLES("Inglês"),
    ESPANHOL("Espanhol"),
    FRANCES("Francês"),
    ITALIANO("Italiano");

    /**
    * Nome idioma 
    */
    private String idioma;

    /**
    * Construtor
    * @param idioma nome do idioma
    */
    Idioma (String idioma){
        this.idioma = idioma;
    }

    /**
    * Getter
    * return idioma 
    */
    public String getIdioma() {
        return this.idioma;
    }
}



