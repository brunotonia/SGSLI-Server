package DAO;

import VO.RepositorioSecurity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSecurityDAO {
    
    public RepositorioSecurity selecionar(Integer id) throws Exception {
        RepositorioSecurity repositorio = null;
        String sql = "select * from repositorio_security where id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            
        }
        rs.close();
        ps.close();
        cnn.close();
        return repositorio;
    }
    
    public List<RepositorioSecurity> listar() throws Exception {
        String sql = "select * from repositorio_security order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<RepositorioSecurity> lista = new ArrayList<RepositorioSecurity>();
        while (rs.next()) {
            
            RepositorioSecurity repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            
            lista.add(repositorio);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<RepositorioSecurity> listarAtivos() throws Exception {
        String sql = "select * from repositorio_security where ativo = ? order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, true);
        ResultSet rs = ps.executeQuery();
        List<RepositorioSecurity> lista = new ArrayList<RepositorioSecurity>();
        while (rs.next()) {
            
            RepositorioSecurity repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            lista.add(repositorio);
            
        }
        rs.close();
        ps.close();
        return lista;
    }
    
    public List<RepositorioSecurity> listarInativos() throws Exception {
        String sql = "select * from repositorio_security where ativo = ? order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, false);
        ResultSet rs = ps.executeQuery();
        List<RepositorioSecurity> lista = new ArrayList<RepositorioSecurity>();
        while (rs.next()) {
            
            RepositorioSecurity repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            lista.add(repositorio);
            
        }
        rs.close();
        ps.close();
        return lista;
    }
    
}
