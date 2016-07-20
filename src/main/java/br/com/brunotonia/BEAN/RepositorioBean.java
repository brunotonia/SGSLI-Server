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

import br.com.brunotonia.BO.RepositorioBO;
import br.com.brunotonia.BO.RepositorioTipoBO;
import br.com.brunotonia.VO.Repositorio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "repositorioBean")
public class RepositorioBean implements Serializable {

    Repositorio repositorio = new Repositorio();
    List repositorios = new ArrayList();
    Integer tipo = new Integer(0);
    String mensagem = "";

    public RepositorioBean() {
        repositorios = new RepositorioBO().listar();
        repositorio = new Repositorio();
        tipo = new Integer(0);
        mensagem = "";
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters e Setters
    public Repositorio getrepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(List repositorios) {
        this.repositorios = repositorios;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    ///////////////////////////////////////////////////////////////////////////
    //Métodos dos botões 

    public String cadastrar(ActionEvent actionEvent) {
        String str = "index?faces-redirect=true";
        repositorio.setTipo(new RepositorioTipoBO().selecionar(tipo));
        Boolean resultado = new RepositorioBO().adicionar(repositorio);
        if (resultado) {
            mensagem = "Repositorio cadastrado!";
            str = "/repositorios?faces-redirect=true";
        } else {
            mensagem = "Repositorio cadastrado!";
        }
        return str;
    }

    public void alterar(ActionEvent actionEvent) {
        /*new RepositorioBO().alterar(repositorio);
		repositorios = new RepositorioBO().listarAtivos();
		repositorio = new Repositorio();*/
    }

    public void excluir(ActionEvent actionEvent) {
        /*new RepositorioBO().excluir(repositorio);
		repositorios = new RepositorioBO().listarAtivos();
		repositorio = new Repositorio();*/
    }

    //getters and setters
}
