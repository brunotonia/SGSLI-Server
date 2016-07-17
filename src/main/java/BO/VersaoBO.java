package BO;

import DAO.VersaoDAO;
import VO.Versao;

public class VersaoBO {
    
    public VersaoBO() {
        
    }
    
    public Versao selecionar() {
        try {
            return new VersaoDAO().selecionar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
