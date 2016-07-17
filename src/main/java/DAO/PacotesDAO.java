package DAO;

import VO.Pacotes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacotesDAO {

    public void adicionar(Pacotes p) throws Exception {
        String sql;
        sql = "insert into pacotes "
                + "(\"pacote\", \"versao\", \"dependencias\", \"descricao\", \"categoria\", \"ativo\")"
                + " values "
                + "(?, ?, ?, ?, ?, ?)";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setString(1, p.getPacote().toLowerCase());
        ps.setString(2, p.getVersao().toLowerCase());
        ps.setString(3, p.getDependencias().toLowerCase());
        ps.setString(4, p.getDescricao());
        ps.setInt(5, p.getCategoria().getId());
        ps.setBoolean(5, p.getAtivo());

        ps.execute();
        ps.close();
        cnn.close();
    }

    public Pacotes selecionar(Integer id) throws Exception {
        Pacotes pacote = null;
        String sql = "select * from pacotes where id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));

        }
        rs.close();
        ps.close();
        return pacote;
    }

    public Pacotes selecionar(String nomePacote) throws Exception {
        Pacotes pacote = null;
        String sql = "select * from pacotes where pacote = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, nomePacote);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
            
        }
        rs.close();
        ps.close();
        return pacote;
    }
    
    public List<Pacotes> listar() throws Exception {
        String sql = "select * from pacotes order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pacotes> lista = new ArrayList<Pacotes>();
        while (rs.next()) {
            Pacotes pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
            lista.add(pacote);
        }
        rs.close();
        ps.close();
        return lista;
    }
    
    public List<Pacotes> listarAtivos() throws Exception {
        String sql = "select * from pacotes where ativo = \"true\" order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pacotes> lista = new ArrayList<Pacotes>();
        while (rs.next()) {
            
            Pacotes pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
            lista.add(pacote);
            
        }
        rs.close();
        ps.close();
        return lista;
    }
    
    public List<Pacotes> listarInativos() throws Exception {
        String sql = "select * from pacotes where ativo = \"false\" order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pacotes> lista = new ArrayList<Pacotes>();
        while (rs.next()) {
            
            Pacotes pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
            lista.add(pacote);
            
        }
        rs.close();
        ps.close();
        return lista;
    }

}
