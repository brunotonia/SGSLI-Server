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

import br.com.brunotonia.BO.InstalacaoBO;
import br.com.brunotonia.VO.Instalacao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "instalacaoBean")
public class InstalacaoBean {
    
    private Instalacao instalacao = new Instalacao();
    private List<Instalacao> listaInstalacao = new InstalacaoBO().listar();

    public InstalacaoBean() {
        this.instalacao = new Instalacao();
        this.listaInstalacao = new InstalacaoBO().listar();
    }

    public Instalacao getUsuario() {
        return instalacao;
    }

    public void setUsuario(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    public List<Instalacao> getListaUsuarios() {
        return listaInstalacao;
    }

    public void setListaUsuarios(List<Instalacao> listaInstalacao) {
        this.listaInstalacao = listaInstalacao;
    }
    
    public void prepararAdicionar(ActionEvent actionEvent) {
        this.instalacao = new Instalacao();
        this.listaInstalacao = new InstalacaoBO().listar();
    }
    
    public void adicionar(ActionEvent actionEvent) {
        new InstalacaoBO().adicionar(instalacao);
        prepararAdicionar(actionEvent);
    }
    
    public void ativarDesativar(ActionEvent actionEvent) {
        System.err.println("excluir");
        new InstalacaoBO().ativarDesativar(instalacao);
        prepararAdicionar(actionEvent);
    }
}
