package BO;

import DAO.RepositorioSecurityDAO;
import VO.RepositorioSecurity;
import java.util.List;

public class RepositorioSecurityBO {

    public RepositorioSecurityBO() {
    }
    
    public RepositorioSecurity selecionar(Integer id) {
        try {
            return new RepositorioSecurityDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<RepositorioSecurity> listar() {
        try {
            return new RepositorioSecurityDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<RepositorioSecurity> listarAtivos() {
        try {
            return new RepositorioSecurityDAO().listarAtivos();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
}
