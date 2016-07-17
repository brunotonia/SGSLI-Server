package br.com.brunotonia.VO;

public class Pacotes {

    private Integer id;
    private PacotesCategoria categoria;
    private String pacote;
    private String versao;
    private String dependencias;
    private String descricao;
    private Boolean ativo;

    public Pacotes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PacotesCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(PacotesCategoria categoria) {
        this.categoria = categoria;
    }

    public String getPacote() {
        return pacote;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getDependencias() {
        return dependencias;
    }

    public void setDependencias(String dependencias) {
        this.dependencias = dependencias;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    

}
