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

import br.com.brunotonia.DAO.RepositorioTipoDAO;
import br.com.brunotonia.VO.RepositorioTipo;
import java.util.List;

public class RepositorioTipoBO {

    public RepositorioTipoBO() {

    }

    public RepositorioTipo selecionar(Integer id) {
        try {
            return new RepositorioTipoDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public RepositorioTipo selecionar(String tipo) {
        try {
            return new RepositorioTipoDAO().selecionar(tipo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<RepositorioTipo> listar() {
        try {
            return new RepositorioTipoDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
