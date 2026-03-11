import java.util.Date;

public abstract class Publicacion {

    protected int id;
    protected Date fechaPublicacion;
    protected int numeroReacciones;
    protected Usuario autor;

    public Publicacion(int id, Usuario autor) {
        this.id = id;
        this.autor = autor;
        this.fechaPublicacion = new Date();
        this.numeroReacciones = 0;
    }

    public void darMeGusta() {
        numeroReacciones++;
    }

    public Date getFecha() {
        return fechaPublicacion;
    }

    public int getNumeroReacciones() {
        return numeroReacciones;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setFecha(Date fecha) {
    this.fechaPublicacion = fecha;
}
}