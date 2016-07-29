package br.com.brunotonia.DAO;

import br.com.brunotonia.VO.Instalacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InstalacaoDAO {

    public void adicionar(Instalacao p) throws Exception {
        String sql = "INSERT INTO instalacao "
                + "(\"pacote\", \"ativo\")"
                + " VALUES "
                + "(?, ?)";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setInt(1, p.getPacote().getId());
        ps.setBoolean(2, p.getAtivo());

        ps.execute();
        ps.close();
        cnn.close();
    }
    
    public Instalacao selecionar(Integer id) throws Exception {
        Instalacao instalacao = null;
        String sql = "SELECT * FROM instalacao WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            instalacao = new Instalacao();
            instalacao.setId(rs.getInt("id"));
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            instalacao.setAtivo(rs.getBoolean("ativo"));

        }
        rs.close();
        ps.close();
        cnn.close();
        return instalacao;
    }
    
    public void ativarDesativar (Instalacao p) throws Exception {
        String sql = "UPDATE instalacao SET "
                + " ativo = ?,"
                + " WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setBoolean(1, !p.getAtivo());
        ps.setInt(2, p.getPacote().getId());

        ps.execute();
        ps.close();
        cnn.close();
    }
    
    
    public List<Instalacao> listar() throws Exception {
        String sql = "SELECT * FROM instalacao ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Instalacao> lista = new ArrayList<Instalacao>();
        while (rs.next()) {
            Instalacao instalacao = new Instalacao();
            instalacao.setId(rs.getInt("id"));
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            lista.add(instalacao);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<Instalacao> listar(Integer id) throws Exception {
        String sql = "SELECT * FROM instalacao WHERE id > ? AND ativo = ? ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setBoolean(2, true);
        ResultSet rs = ps.executeQuery();
        List<Instalacao> lista = new ArrayList<Instalacao>();
        while (rs.next()) {
            Instalacao instalacao = new Instalacao();
            instalacao.setId(rs.getInt("id"));
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            lista.add(instalacao);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }

}
