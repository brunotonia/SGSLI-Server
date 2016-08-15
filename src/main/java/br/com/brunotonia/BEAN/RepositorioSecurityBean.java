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
package br.com.brunotonia.BEAN;

import br.com.brunotonia.BO.RepositorioSecurityBO;
import br.com.brunotonia.BO.RepositorioTipoBO;
import br.com.brunotonia.BO.VersaoBO;
import br.com.brunotonia.VO.RepositorioSecurity;
import br.com.brunotonia.VO.RepositorioTipo;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "repositorioSecurityBean")
@ViewScoped
public class RepositorioSecurityBean implements Serializable {

    private RepositorioSecurity repositorio = new RepositorioSecurity();
    private List<RepositorioSecurity> listaRepositorios = new RepositorioSecurityBO().listar();
    private RepositorioTipo tipo = new RepositorioTipo();
    private List<RepositorioTipo> listaTipos = new RepositorioTipoBO().listar();
    private Integer idTipo;

    public RepositorioSecurityBean() {
        repositorio = new RepositorioSecurity();
        listaRepositorios = new RepositorioSecurityBO().listar();
        tipo = new RepositorioTipo();
        listaTipos = new RepositorioTipoBO().listar();
    }

    public RepositorioSecurity getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioSecurity repositorio) {
        this.repositorio = repositorio;
    }

    public List<RepositorioSecurity> getListaRepositorios() {
        return listaRepositorios;
    }

    public void setListaRepositorios(List listaRepositorios) {
        this.listaRepositorios = listaRepositorios;
    }

    public RepositorioTipo getTipo() {
        return tipo;
    }

    public void setTipo(RepositorioTipo tipo) {
        this.tipo = tipo;
    }

    public List<RepositorioTipo> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List listaTipos) {
        this.listaTipos = listaTipos;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public void prepararAdicionar(ActionEvent actionEvent) {
        repositorio = new RepositorioSecurity();
        tipo = new RepositorioTipo();
        listaRepositorios = new RepositorioSecurityBO().listar();
        idTipo = 0;
    }

    public void adicionar(ActionEvent actionEvent) {
        repositorio.setTipo(new RepositorioTipoBO().selecionar(idTipo));
        new RepositorioSecurityBO().adicionar(repositorio);
        new VersaoBO().incrementarUpdate();
        prepararAdicionar(actionEvent);
    }

    public void editar(ActionEvent actionEvent) {
        repositorio.setTipo(new RepositorioTipoBO().selecionar(idTipo));
        new RepositorioSecurityBO().alterar(repositorio);
        new VersaoBO().incrementarUpdate();
        prepararAdicionar(actionEvent);
    }

    public void excluir(ActionEvent actionEvent) {
        new RepositorioSecurityBO().excluir(repositorio.getId());
        new VersaoBO().incrementarUpdate();
        prepararAdicionar(actionEvent);
    }

}
