public class PublicacionImagen extends Publicacion {

    private String urlImagen;
    private String resolucion;

    public PublicacionImagen(int id, Usuario autor, String urlImagen, String resolucion) {
        super(id, autor);
        this.urlImagen = urlImagen;
        this.resolucion = resolucion;
    }

    public String getResolucion() {
        return resolucion;
    }
}