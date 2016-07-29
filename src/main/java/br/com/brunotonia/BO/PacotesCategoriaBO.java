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

import br.com.brunotonia.DAO.PacotesCategoriaDAO;
import br.com.brunotonia.VO.PacotesCategoria;
import java.util.List;

public class PacotesCategoriaBO {
    
    public PacotesCategoriaBO() {
        
    }
    
    public void adicionar(PacotesCategoria pctCategoria) {
        try {
            new PacotesCategoriaDAO().adicionar(pctCategoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public PacotesCategoria selecionar(Integer id) {
        try {
            return new PacotesCategoriaDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public PacotesCategoria selecionar(String categoria) {
        try {
            return new PacotesCategoriaDAO().selecionar(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<PacotesCategoria> listar() {
        try {
            return new PacotesCategoriaDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
