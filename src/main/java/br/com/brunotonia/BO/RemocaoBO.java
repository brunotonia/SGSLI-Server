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

import br.com.brunotonia.DAO.RemocaoDAO;
import br.com.brunotonia.VO.Remocao;
import java.util.List;

public class RemocaoBO {
    
    public void adicionar(Remocao instalacao) {
        try {
            new RemocaoDAO().adicionar(instalacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Remocao selecionar(Integer id) {
        try {
            return new RemocaoDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void ativarDesativar(Remocao instalacao) {
        try {
            new RemocaoDAO().ativarDesativar(instalacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Remocao> listar() {
        try {
            return new RemocaoDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Remocao> listar(Integer id) {
        try {
            return new RemocaoDAO().listar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
