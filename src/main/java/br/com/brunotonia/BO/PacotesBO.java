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
