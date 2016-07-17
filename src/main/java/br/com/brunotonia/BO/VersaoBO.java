package br.com.brunotonia.BO;

import br.com.brunotonia.DAO.VersaoDAO;
import br.com.brunotonia.VO.Versao;

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
