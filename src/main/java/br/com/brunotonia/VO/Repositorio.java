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

import java.io.Serializable;

public class Repositorio implements Serializable {
    
    private Integer id;
    private RepositorioTipo repositorioTipo;
    private String url;
    private String versao;
    private String repositorios;
    private String descricao;
    private Boolean ativo;

    public Repositorio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RepositorioTipo getTipo() {
        return repositorioTipo;
    }

    public void setTipo(RepositorioTipo repositorioTipo) {
        this.repositorioTipo = repositorioTipo;
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
        return repositorioTipo.getTipo() + " " + url + " " + versao + " " + repositorios;
    }
    
}
