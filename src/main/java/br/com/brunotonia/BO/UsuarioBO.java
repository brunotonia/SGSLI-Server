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
package br.com.brunotonia.BO;

import br.com.brunotonia.DAO.UsuarioDAO;
import br.com.brunotonia.VO.Usuario;

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
    
    public Usuario selecinar(Integer id) {
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
    
}
