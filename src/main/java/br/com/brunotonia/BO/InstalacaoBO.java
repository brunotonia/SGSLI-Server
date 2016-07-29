package br.com.brunotonia.BO;

import br.com.brunotonia.DAO.InstalacaoDAO;
import br.com.brunotonia.VO.Instalacao;
import java.util.List;

public class InstalacaoBO {
    
    public void adicionar(Instalacao instalacao) {
        try {
            new InstalacaoDAO().adicionar(instalacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Instalacao selecionar(Integer id) {
        try {
            return new InstalacaoDAO().selecionar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void ativarDesativar(Instalacao instalacao) {
        try {
            new InstalacaoDAO().ativarDesativar(instalacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Instalacao> listar() {
        try {
            return new InstalacaoDAO().listar();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Instalacao> listar(Integer id) {
        try {
            return new InstalacaoDAO().listar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
