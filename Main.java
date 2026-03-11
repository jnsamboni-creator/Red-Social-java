import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        String linea = "--------------------------------------------";

        System.out.println("=========== RED SOCIAL ===========");
        System.out.println(linea);

        // Crear sistema
        SistemaRedSocial sistema = new SistemaRedSocial();

        // Registrar usuarios
        Usuario ana = new Usuario(1, "Ana");
        Usuario carlos = new Usuario(2, "Carlos");
        Usuario maria = new Usuario(3, "Maria");

        sistema.registrarUsuario(ana);
        sistema.registrarUsuario(carlos);
        sistema.registrarUsuario(maria);

        System.out.println("Usuarios registrados:");
        System.out.println("- " + ana.getNombreVisible());
        System.out.println("- " + carlos.getNombreVisible());
        System.out.println("- " + maria.getNombreVisible());

        System.out.println(linea);

        // Seguir usuarios
        System.out.println("Ana comienza a seguir a Carlos");
        ana.seguir(carlos);

        System.out.println("Ana comienza a seguir a Maria");
        ana.seguir(maria);

        System.out.println(linea);

        // Crear publicaciones
        System.out.println("Carlos crea publicaciones");

        PublicacionTexto publicacion1 =
                new PublicacionTexto(1, carlos, "Hola! Esta es mi primera publicación");

        PublicacionImagen publicacion2 =
                new PublicacionImagen(2, carlos, "foto.jpg", "1080x1080");

        carlos.publicar(publicacion1);
        carlos.publicar(publicacion2);

        System.out.println("Maria crea una publicación");

        PublicacionVideo publicacion3 =
                new PublicacionVideo(3, maria, "video.mp4", 30);

        maria.publicar(publicacion3);

        // Simular fechas anteriores
        Calendar calendario = Calendar.getInstance();

        calendario.add(Calendar.DAY_OF_MONTH, -2); // hace 2 días
        publicacion1.setFecha(calendario.getTime());

        calendario = Calendar.getInstance();
        calendario.add(Calendar.DAY_OF_MONTH, -1); // hace 1 día
        publicacion2.setFecha(calendario.getTime());

        calendario = Calendar.getInstance(); // hoy
        publicacion3.setFecha(calendario.getTime());

        System.out.println(linea);

        // Dar likes
        System.out.println("Ana reacciona a la publicación de Carlos");
        publicacion1.darMeGusta();

        System.out.println("Carlos reacciona al video de Maria");
        publicacion3.darMeGusta();

        System.out.println(linea);

        // Flujo de contenido
        System.out.println("========= FLUJO DE ANA =========");

        List<Publicacion> flujo = ana.verFlujo();

        SimpleDateFormat formato = new SimpleDateFormat(
                "EEEE dd 'de' MMMM yyyy HH:mm",
                new Locale("es", "ES"));

        for (Publicacion p : flujo) {

            System.out.println(linea);

            System.out.println("Autor: " + p.getAutor().getNombreVisible());
            System.out.println("Fecha: " + formato.format(p.getFecha()));
            System.out.println("Reacciones: " + p.getNumeroReacciones());

            if (p instanceof PublicacionTexto) {

                PublicacionTexto texto = (PublicacionTexto) p;
                System.out.println("Tipo: Texto");
                System.out.println("Contenido: " + texto.getContenido());
            }

            else if (p instanceof PublicacionImagen) {

                PublicacionImagen imagen = (PublicacionImagen) p;
                System.out.println("Tipo: Imagen");
                System.out.println("Resolución: " + imagen.getResolucion());
            }

            else if (p instanceof PublicacionVideo) {

                PublicacionVideo video = (PublicacionVideo) p;
                System.out.println("Tipo: Video");
                System.out.println("Duración: " + video.getDuracion() + " segundos");
            }
        }

        System.out.println(linea);
        System.out.println("========= FIN DEL FLUJO =========");
    }
}