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

import br.com.brunotonia.BO.RemocaoBO;
import br.com.brunotonia.VO.Remocao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "remocaoBean")
public class RemocaoBean {
    
    private Remocao remocao = new Remocao();
    private List<Remocao> listaRemocao = new RemocaoBO().listar();

    public RemocaoBean() {
        this.remocao = new Remocao();
        this.listaRemocao = new RemocaoBO().listar();
    }

    public Remocao getUsuario() {
        return remocao;
    }

    public void setUsuario(Remocao remocao) {
        this.remocao = remocao;
    }

    public List<Remocao> getListaUsuarios() {
        return listaRemocao;
    }

    public void setListaUsuarios(List<Remocao> listaRemocao) {
        this.listaRemocao = listaRemocao;
    }
    
    public void prepararAdicionar(ActionEvent actionEvent) {
        this.remocao = new Remocao();
        this.listaRemocao = new RemocaoBO().listar();
    }
    
    public void adicionar(ActionEvent actionEvent) {
        new RemocaoBO().adicionar(remocao);
        prepararAdicionar(actionEvent);
    }
    
    public void ativarDesativar(ActionEvent actionEvent) {
        System.err.println("excluir");
        new RemocaoBO().ativarDesativar(remocao);
        prepararAdicionar(actionEvent);
    }
}
