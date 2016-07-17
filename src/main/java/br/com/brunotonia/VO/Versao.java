package br.com.brunotonia.VO;

public class Versao {

    private Integer id;
    private Integer sources;
    private Integer instalacao;
    private Integer remocao;
    private Integer upgrade;
    private Integer distUpdate;
    
    public Versao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getSources() {
        return this.sources;
    }

    public void setSources(Integer sources) {
        this.sources = sources;
    }

    public Integer getInstalacao() {
        return this.instalacao;
    }

    public void setInstalacao(Integer instalacao) {
        this.instalacao = instalacao;
    }

    public Integer getRemocao() {
        return this.remocao;
    }

    public void setRemocao(Integer remocao) {
        this.remocao = remocao;
    }

    public Integer getUpgrade() {
        return this.upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }
    
    public Integer getDistUpdate() {
        return this.distUpdate;
    }

    public void setDistUpdate(Integer distUpdate) {
        this.distUpdate = distUpdate;
    }
    
    @Override
    public String toString() {
        return "Versões:\n"
                + "  sources = " + sources + "\n"
                + "  instalação = " + instalacao + "\n"
                + "  remoção = " + remocao + "\n"
                + "  upgrade = " + upgrade+ "\n"
                + "  distUpdate = " + distUpdate;
    }
    
}
