package DAO;

import VO.Instalacao;
import VO.Pacotes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InstalacaoDAO {

    public void adicionar(Instalacao p) throws Exception {
        String sql;
        sql = "insert into instalacao "
                + "(\"pacote\", \"ativo\")"
                + " values "
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
        String sql = "select * from instalacao where id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            instalacao = new Instalacao();
            instalacao.setId(rs.getInt("id"));
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getString("pacote")));
            instalacao.setAtivo(rs.getBoolean("ativo"));

        }
        rs.close();
        ps.close();
        cnn.close();
        return instalacao;
    }
    
    public List<Instalacao> listar() throws Exception {
        String sql = "select * from instalacao order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Instalacao> lista = new ArrayList<Instalacao>();
        while (rs.next()) {
            Instalacao instalacao = new Instalacao();
            instalacao.setId(rs.getInt("id"));
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getString("pacote")));
            lista.add(instalacao);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<Instalacao> listar(Integer id) throws Exception {
        String sql = "select * from instalacao where id > ? and ativo = ? order by id ";
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
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getString("pacote")));
            lista.add(instalacao);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }

}
