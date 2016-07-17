package br.com.brunotonia.VO;

public class Instalacao {
    
    private Integer id;
    private Pacotes pacote;
    private Boolean ativo;

    public Instalacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pacotes getPacote() {
        return pacote;
    }

    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
