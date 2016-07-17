package br.com.brunotonia.BO;

import br.com.brunotonia.DAO.PacotesCategoriaDAO;
import br.com.brunotonia.VO.PacotesCategoria;
import java.util.List;

public class PacotesCategoriaBO {
    
    public PacotesCategoriaBO() {
        
    }
    
    public void adicionar(PacotesCategoria pctCategoria) {
        try {
            new PacotesCategoriaDAO().adicionar(pctCategoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public PacotesCategoria selecionar(Integer id) {
        try {
            return new PacotesCategoriaDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public PacotesCategoria selecionar(String categoria) {
        try {
            return new PacotesCategoriaDAO().selecionar(categoria);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<PacotesCategoria> listar() {
        try {
            return new PacotesCategoriaDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
