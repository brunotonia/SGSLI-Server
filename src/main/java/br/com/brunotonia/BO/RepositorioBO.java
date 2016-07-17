package br.com.brunotonia.BO;

import br.com.brunotonia.DAO.RepositorioDAO;
import br.com.brunotonia.VO.Repositorio;
import java.util.List;

public class RepositorioBO {
    
    public RepositorioBO() {

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