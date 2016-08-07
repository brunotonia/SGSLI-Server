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

import br.com.brunotonia.BO.UsuarioBO;
import br.com.brunotonia.BO.UsuarioTipoBO;
import br.com.brunotonia.VO.Usuario;
import br.com.brunotonia.VO.UsuarioTipo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
    private Usuario usuario = new Usuario();
    private List<Usuario> listaUsuarios = new UsuarioBO().listar();
    private UsuarioTipo tipo = new UsuarioTipo();
    private List<UsuarioTipo> listaTipos = new UsuarioTipoBO().listar();
    private Integer idTipo;

    public UsuarioBean() {
        usuario = new Usuario();
        listaUsuarios = new UsuarioBO().listar();
        tipo = new UsuarioTipo();
        listaTipos = new UsuarioTipoBO().listar();
    }

    public Usuario getRepositorio() {
        return usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public UsuarioTipo getTipo() {
        return tipo;
    }

    public void setTipo(UsuarioTipo tipo) {
        this.tipo = tipo;
    }

    public List<UsuarioTipo> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List<UsuarioTipo> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
    
    public void prepararAdicionar(ActionEvent actionEvent) {
        usuario = new Usuario();
        tipo = new UsuarioTipo();
        listaUsuarios = new UsuarioBO().listar();
        idTipo = 0;
    }
    
    public void adicionar(ActionEvent actionEvent) {
        usuario.setTipo(new UsuarioTipoBO().selecionar(idTipo));
        new UsuarioBO().adicionar(usuario);
        prepararAdicionar(actionEvent);
    }
    
    public void editar(ActionEvent actionEvent) {
        usuario.setTipo(new UsuarioTipoBO().selecionar(idTipo));
        new UsuarioBO().alterar(usuario);
        prepararAdicionar(actionEvent);
    }
    
    public void excluir(ActionEvent actionEvent) {
        new UsuarioBO().excluir(usuario.getId());
        prepararAdicionar(actionEvent);
    }
    
    public void alterarSenha(ActionEvent actionEvent) {
        new UsuarioBO().alterarSenha(usuario);
        prepararAdicionar(actionEvent);
    } 
    
    public void ativarDesativar(ActionEvent actionEvent) {
        new UsuarioBO().ativarDesativar(usuario);
        prepararAdicionar(actionEvent);
    } 
    
}
