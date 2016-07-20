package br.com.brunotonia.VO;

import java.io.Serializable;

public class RepositorioTipo implements Serializable {
    
    private Integer id;
    private String tipo;

    public RepositorioTipo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    
}
