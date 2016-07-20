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
