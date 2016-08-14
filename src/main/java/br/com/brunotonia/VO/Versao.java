/*
 * Copyright (C) 2016 Bruno Roberto Vasconcelos Tonia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.brunotonia.VO;

public class Versao {

    private Integer id;
    private Integer sources;
    private Integer instalacao;
    private Integer remocao;
    private Integer update;
    private String dataUpdate;
    private Integer upgrade;
    private String dataUpgrade;
    private Integer distUpgrade;
    private String dataDistUpGrade;
    private String dataListaPacotes;
    
    public Versao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSources() {
        return sources;
    }

    public void setSources(Integer sources) {
        this.sources = sources;
    }

    public Integer getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(Integer instalacao) {
        this.instalacao = instalacao;
    }

    public Integer getRemocao() {
        return remocao;
    }

    public void setRemocao(Integer remocao) {
        this.remocao = remocao;
    }

    public Integer getUpdate() {
        return update;
    }

    public void setUpdate(Integer update) {
        this.update = update;
    }

    public String getDataUpdate() {
        return dataUpdate;
    }

    public void setDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
    }

    public Integer getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Integer upgrade) {
        this.upgrade = upgrade;
    }

    public String getDataUpgrade() {
        return dataUpgrade;
    }

    public void setDataUpgrade(String dataUpgrade) {
        this.dataUpgrade = dataUpgrade;
    }

    public Integer getDistUpgrade() {
        return distUpgrade;
    }

    public void setDistUpgrade(Integer distUpgrade) {
        this.distUpgrade = distUpgrade;
    }

    public String getDataDistUpGrade() {
        return dataDistUpGrade;
    }

    public void setDataDistUpGrade(String dataDistUpGrade) {
        this.dataDistUpGrade = dataDistUpGrade;
    }

    public String getDataListaPacotes() {
        return dataListaPacotes;
    }

    public void setDataListaPacotes(String dataListaPacotes) {
        this.dataListaPacotes = dataListaPacotes;
    }
    
    @Override
    public String toString() {
        return "Versões:\n"
                + "  sources = " + sources + "\n"
                + "  instalação = " + instalacao + "\n"
                + "  remoção = " + remocao + "\n"
                + "  update = " + update + "\n"
                + "  upgrade = " + upgrade+ "\n"
                + "  distUpdate = " + distUpgrade;
    }
    
}
