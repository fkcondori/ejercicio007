package cic.ejer007;

public class Tarea {
    private Long id;
    private String descripcion;
    private boolean completada;

    // Constructor
    public Tarea(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = false;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
