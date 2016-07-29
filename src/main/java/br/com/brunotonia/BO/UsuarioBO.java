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
package br.com.brunotonia.BO;

import br.com.brunotonia.DAO.UsuarioDAO;
import br.com.brunotonia.VO.Usuario;
import java.util.List;

/**
 *
 * @author bruno
 */
public class UsuarioBO {
    
    public void adicionar(Usuario usuario) {
        try {
            new UsuarioDAO().adicionar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void alterar(Usuario usuario) {
        try {
            new UsuarioDAO().alterar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void alterarSenha(Usuario usuario) {
        try {
            new UsuarioDAO().alterarSenha(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ativarDesativar(Usuario usuario) {
        try {
            new UsuarioDAO().ativarDesativar(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluir(Integer id) {
        try {
            new UsuarioDAO().excluir(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Usuario selecionar(Integer id) {
        try {
            return new UsuarioDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Usuario login(String login, String senha) {
        try {
            return new UsuarioDAO().login(login, senha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Usuario> listar() {
        try {
            return new UsuarioDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
