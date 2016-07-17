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

import br.com.brunotonia.DAO.UsuarioTipoDAO;
import br.com.brunotonia.VO.RepositorioTipo;
import br.com.brunotonia.VO.UsuarioTipo;
import java.util.List;

public class UsuarioTipoBO {
    
    public UsuarioTipoBO() {

    }

    public UsuarioTipo selecionar(Integer id) {
        try {
            return new UsuarioTipoDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UsuarioTipo> listar() {
        try {
            return new UsuarioTipoDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
