public class PublicacionVideo extends Publicacion {

    private String urlVideo;
    private int duracion;

    public PublicacionVideo(int id, Usuario autor, String urlVideo, int duracion) {
        super(id, autor);
        this.urlVideo = urlVideo;
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }
}