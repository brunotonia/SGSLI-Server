package VO;

public class RepositorioSecurity {
    
    private Integer id;
    private RepositorioTipo tipo;
    private String url;
    private String versao;
    private String repositorios;
    private String descricao;
    private Boolean ativo;

    public RepositorioSecurity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RepositorioTipo getTipo() {
        return tipo;
    }

    public void setTipo(RepositorioTipo tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(String repositorios) {
        this.repositorios = repositorios;
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
    
    @Override
    public String toString() {
        return tipo.getTipo() + " " + url + " " + versao + " " + repositorios;
    }
    
}
