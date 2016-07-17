package br.com.brunotonia.VO;

public class PacotesCategoria {
    
    private Integer id;
    private String categoria;

    public PacotesCategoria() {
    }

    public PacotesCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return categoria;
    }
    
}
