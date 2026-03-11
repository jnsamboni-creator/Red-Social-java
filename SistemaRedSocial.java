import java.util.ArrayList;
import java.util.List;

public class SistemaRedSocial {

    private List<Usuario> usuarios;

    public SistemaRedSocial() {
        usuarios = new ArrayList<>();
    }

    public void registrarUsuario(Usuario u) {
        if (u != null && !usuarios.contains(u)) {
        usuarios.add(u);
        }
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
}