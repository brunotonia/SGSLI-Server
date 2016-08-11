/*
 * Copyright (C) 2016 bruno
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

import br.com.brunotonia.BO.InstalacaoBO;
import br.com.brunotonia.BO.PacotesBO;
import br.com.brunotonia.BO.PacotesCategoriaBO;
import br.com.brunotonia.VO.Instalacao;
import br.com.brunotonia.VO.Pacotes;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "instalacaoBean")
@ViewScoped
public class InstalacaoBean implements Serializable {
    
    private Instalacao instalacao;
    private Pacotes pacote;
    private List listaInstalacao;
    private List listaPacotes;
    private List listaCategorias;
    private static Integer idCategoria;
    private Integer idPacote;
    private Integer idVisualizacao;

    public InstalacaoBean() {
        this.instalacao = new Instalacao();
        this.pacote = new Pacotes();
        this.listaInstalacao = new InstalacaoBO().listar();
        this.idCategoria = 0;
        this.idVisualizacao = 0;
    }

    public Instalacao getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    public Pacotes getPacote() {
        return pacote;
    }

    public void setPacote(Pacotes pacote) {
        this.pacote = pacote;
    }

    public List getListaInstalacao() {
        return listaInstalacao;
    }

    public void setListaInstalacao(List listaInstalacao) {
        this.listaInstalacao = listaInstalacao;
    }

    public List getListaPacotes() {
        return listaPacotes;
    }

    public void setListaPacotes(List listaPacotes) {
        this.listaPacotes = listaPacotes;
    }

    public List getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Integer idPacote) {
        this.idPacote = idPacote;
    }

    public Integer getIdVisualizacao() {
        return idVisualizacao;
    }

    public void setIdVisualizacao(Integer idVisualizacao) {
        this.idVisualizacao = idVisualizacao;
    }

    public void preparar(ActionEvent actionEvent) {
        this.instalacao = new Instalacao();
        this.listaInstalacao = new InstalacaoBO().listar();
    }
    
    public void ativarDesativar(ActionEvent actionEvent) {
        new InstalacaoBO().ativarDesativar(new InstalacaoBO().selecionar(instalacao.getId()));
        preparar(actionEvent);
    }
    
    public void prepararAdicionar(ActionEvent actionEvent) {
        this.listaCategorias = new PacotesCategoriaBO().listar();
        this.listaPacotes = new PacotesBO().listarAtivos();
    }
    
    // Era a variável de parametro!
    public void listarPacotes(ValueChangeEvent valueChangeEvent) {
        if (idCategoria == 0) {
            this.listaPacotes = new PacotesBO().listarAtivos();
        } else {
            this.listaPacotes = new PacotesBO().listarAtivosPorCategoria(idCategoria);
        }   
    }
    
    public void adicionar(ActionEvent actionEvent) {
        instalacao.setPacote(new PacotesBO().selecionar(idPacote));
        instalacao.setAtivo(true);
        new InstalacaoBO().adicionar(instalacao);
        preparar(actionEvent);
    }
    
    public void prepararVisualizar(ActionEvent actionEvent) {
        this.idVisualizacao = 0;
    }
    
}
