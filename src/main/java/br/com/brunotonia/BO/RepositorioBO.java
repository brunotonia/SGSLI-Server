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

import br.com.brunotonia.DAO.RepositorioDAO;
import br.com.brunotonia.VO.Repositorio;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RepositorioBO {
    
    private Repositorio livro;

    public RepositorioBO() {

    }
    
    public Boolean adicionar(Repositorio repositorio) {
        try {
            new RepositorioDAO().adicionar(repositorio);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean alterar(Repositorio repositorio) {
        try {
            new RepositorioDAO().editar(repositorio);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean excluir(Integer id) {
        try {
            new RepositorioDAO().excluir(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Repositorio selecionar(Integer id) {
        try {
            return new RepositorioDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Repositorio> listar() {
        try {
            return new RepositorioDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Repositorio> listarAtivos() {
        try {
            return new RepositorioDAO().listarAtivos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
