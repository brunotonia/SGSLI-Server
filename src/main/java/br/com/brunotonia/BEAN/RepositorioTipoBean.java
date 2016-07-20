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
import br.com.brunotonia.VO.RepositorioTipo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "repositoriotipoBean")
@ViewScoped
public class RepositorioTipoBean implements Serializable {
    
    RepositorioTipo tipo = new RepositorioTipo();

    List tipos = new ArrayList();

    //construtor
    public RepositorioTipoBean() {
        tipos = new RepositorioTipoBO().listar();
        tipo = new RepositorioTipo();
    }

    //Métodos dos botões 
    /*public void cadastrar(ActionEvent actionEvent) {
        tipo.setTipo(new RepositorioTipoBO().selecionar(tipo.getTipo().getTipo()));
        new RepositorioTipoBO().adicionar(tipo);
        tipos = new RepositorioBO().listarAtivos();
        tipo = new RepositorioTipo();
    }*/

    public void alterar(ActionEvent actionEvent) {
        /*new RepositorioBO().alterar(tipo);
		tipos = new RepositorioBO().listarAtivos();
		tipo = new Repositorio();*/
    }

    public void excluir(ActionEvent actionEvent) {
        /*new RepositorioBO().excluir(tipo);
		tipos = new RepositorioBO().listarAtivos();
		tipo = new Repositorio();*/
    }

    //getters and setters
    public RepositorioTipo getPessoa() {
        return tipo;
    }

    public void setPessoa(RepositorioTipo tipo) {
        this.tipo = tipo;
    }

    public List getTipos() {
        return tipos;
    }

    public void setPessoas(List tipos) {
        this.tipos = tipos;
    }
    
}
