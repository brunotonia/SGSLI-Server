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

import br.com.brunotonia.DAO.PacotesDAO;
import br.com.brunotonia.VO.Pacotes;
import java.util.List;

public class PacotesBO {
    
    public void adicionar(Pacotes pacote) {
        try {
            new PacotesDAO().adicionar(pacote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void atualizar(Pacotes pacote) {
        try {
            new PacotesDAO().atualizar(pacote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void prepararAtualizar() {
        try {
            new PacotesDAO().prepararAtualizar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Pacotes selecionar(Integer id) {
        try {
            return new PacotesDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Pacotes selecionar(String nomePacote) {
        try {
            return new PacotesDAO().selecionar(nomePacote);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Pacotes> listar() {
        try {
            return new PacotesDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Pacotes> listarAtivosPorCategoria(Integer categoria) {
        try {
            return new PacotesDAO().listarAtivosPorCategoria(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Pacotes> listarAtivos() {
        try {
            return new PacotesDAO().listarAtivos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Pacotes> listarInativos() {
        try {
            return new PacotesDAO().listarInativos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
