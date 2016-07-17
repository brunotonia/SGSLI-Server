package BO;

import DAO.RepositorioTipoDAO;
import VO.RepositorioTipo;
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

    public List<RepositorioTipo> listar() {
        try {
            return new RepositorioTipoDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
