import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private int id;
    private String nombreVisible;

    private List<Usuario> seguidores;
    private List<Usuario> seguidos;
    private List<Publicacion> publicaciones;

    public Usuario(int id, String nombreVisible) {
        this.id = id;
        this.nombreVisible = nombreVisible;

        seguidores = new ArrayList<>();
        seguidos = new ArrayList<>();
        publicaciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombreVisible() {
        return nombreVisible;
    }

    public List<Usuario> getSeguidos() {
        return seguidos;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void seguir(Usuario u) {
     if (u != null && !seguidos.contains(u) && u != this) {
        seguidos.add(u);
        u.seguidores.add(this);
        }
    }

    public void dejarDeSeguir(Usuario u) {
         if (u != null && seguidos.contains(u)) {
        seguidos.remove(u);
        u.seguidores.remove(this);
        }
    }

    public void publicar(Publicacion nuevaPublicacion) {
        if (nuevaPublicacion != null) {
        publicaciones.add(nuevaPublicacion);
        }
    }

    public List<Publicacion> verFlujo() {
        FlujoContenido flujo = new FlujoContenido(this);
        return flujo.generar();
    }
}