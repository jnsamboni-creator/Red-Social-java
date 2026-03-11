import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlujoContenido {

    private Usuario usuario;

    public FlujoContenido(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Publicacion> generar() {

        List<Publicacion> flujo = new ArrayList<>();

        for (Usuario seguido : usuario.getSeguidos()) {
            flujo.addAll(seguido.getPublicaciones());
        }

        ordenarPorFecha(flujo);

        return flujo;
    }

    private void ordenarPorFecha(List<Publicacion> lista) {
        lista.sort(Comparator.comparing(Publicacion::getFecha).reversed());
    }
}