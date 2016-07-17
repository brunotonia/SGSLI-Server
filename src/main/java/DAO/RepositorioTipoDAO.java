package DAO;

import VO.RepositorioTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositorioTipoDAO {
    
    public RepositorioTipo selecionar(Integer id) throws Exception {
        RepositorioTipo repTipo = null;
        String sql = "select * from repositorio_tipo where id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            repTipo = new RepositorioTipo();
            repTipo.setId(rs.getInt("id"));
            repTipo.setTipo(rs.getString("tipo"));
        }
        rs.close();
        ps.close();
        return repTipo;
    }
    
    public List<RepositorioTipo> listar() throws Exception {
        String sql = "select * from repositorio order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<RepositorioTipo> lista = new ArrayList<RepositorioTipo>();
        while (rs.next()) {
            
            RepositorioTipo repTipo = new RepositorioTipo();
            repTipo.setId(rs.getInt("id"));
            repTipo.setTipo(rs.getString("tipo"));
            
            lista.add(repTipo);
        }
        rs.close();
        ps.close();
        return lista;
    }
    
}
