public class PublicacionTexto extends Publicacion {

    private String contenido;
    public static final int MAX_CARACTERES = 500;

    public PublicacionTexto(int id, Usuario autor, String contenido) {
        super(id, autor);
        if (contenido.length() <= MAX_CARACTERES) {
            this.contenido = contenido;
        } else {
            this.contenido = contenido.substring(0, MAX_CARACTERES);
        }
    }

    public boolean validarLongitud() {
        return contenido.length() <= MAX_CARACTERES;
    }

    public String getContenido() {
        return contenido;
    }
}