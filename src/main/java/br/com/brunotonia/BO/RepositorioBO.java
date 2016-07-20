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
