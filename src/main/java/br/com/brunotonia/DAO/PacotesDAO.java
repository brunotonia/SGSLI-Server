/*
 * Copyright (C) 2016 Bruno Roberto Vasconcelos Tonia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.brunotonia.DAO;

import br.com.brunotonia.VO.Pacotes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacotesDAO {

    public void adicionar(Pacotes p) throws Exception {
        String sql = "INSERT INTO pacotes "
                + "(\"pacote\", \"versao\", \"dependencias\", \"descricao\", \"categoria\", \"ativo\")"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, p.getPacote());
        ps.setString(2, p.getVersao());
        ps.setString(3, p.getDependencias());
        ps.setString(4, p.getDescricao());
        ps.setInt(5, p.getCategoria().getId());
        ps.setBoolean(6, true);
        ps.execute();
        ps.close();
        //cnn.commit();
        cnn.close();
    }
    
    public Pacotes atualizar(Pacotes pacote) throws Exception {
        String sql = "UPDATE pacotes SET" +
                "versao = ?, dependencias = ?, descricao = ?, ativo = ? " +
                "WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, pacote.getVersao());
        ps.setString(2, pacote.getDependencias());
        ps.setString(3, pacote.getDescricao());
        ps.setBoolean(4, true);
        ps.setInt(5, pacote.getId());
        ResultSet rs = ps.executeQuery();
        rs.close();
        ps.close();
        cnn.commit();
        cnn.close();
        return pacote;
    }

    public Pacotes selecionar(Integer id) throws Exception {
        Pacotes pacote = null;
        String sql = "SELECT * FROM pacotes WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setPacote(rs.getString("pacote"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return pacote;
    }
    
    
    
    public void prepararAtualizar() throws Exception {
        String sql = "UPDATE pacotes SET ativo = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, false);
        ResultSet rs = ps.executeQuery();
        ps.close();
        cnn.commit();
        cnn.close();
    }

    public Pacotes selecionar(String nomePacote) throws Exception {
        Pacotes pacote = null;
        String sql = "SELECT * FROM pacotes WHERE pacote = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, nomePacote);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setPacote(rs.getString("pacote"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return pacote;
    }
    
    public List<Pacotes> listar() throws Exception {
        //String sql = "SELECT * FROM pacotes ORDER BY id ";
        String sql = "SELECT id, pacote FROM pacotes ORDER BY id ";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pacotes> lista = new ArrayList<Pacotes>();
        while (rs.next()) {
            Pacotes pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setPacote(rs.getString("pacote"));
            /*pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));*/
            pacote.setAtivo(rs.getBoolean("ativo"));
            lista.add(pacote);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<Pacotes> listarAtivos() throws Exception {
        //String sql = "SELECT * FROM pacotes WHERE ativo = ? ORDER BY id ";
        String sql = "SELECT id, pacote FROM pacotes WHERE ativo = ? ORDER BY pacote";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, true);
        ResultSet rs = ps.executeQuery();
        List<Pacotes> lista = new ArrayList<Pacotes>();
        while (rs.next()) {
            Pacotes pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setPacote(rs.getString("pacote"));
            /*pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));*/
            lista.add(pacote);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<Pacotes> listarInativos() throws Exception {
        String sql = "SELECT * FROM pacotes WHERE ativo = ? ORDER BY pacote ";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, false);
        ResultSet rs = ps.executeQuery();
        List<Pacotes> lista = new ArrayList<Pacotes>();
        while (rs.next()) {
            Pacotes pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setPacote(rs.getString("pacote"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
            lista.add(pacote);
            
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<Pacotes> listarAtivosPorCategoria(Integer idCategoria) throws Exception {
        String sql = "SELECT * FROM pacotes WHERE ativo = ? AND categoria = ? ORDER BY pacote ";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, true);
        ps.setInt(2, idCategoria);
        ResultSet rs = ps.executeQuery();
        List<Pacotes> lista = new ArrayList<Pacotes>();
        while (rs.next()) {
            Pacotes pacote = new Pacotes();
            pacote.setId(rs.getInt("id"));
            pacote.setPacote(rs.getString("pacote"));
            pacote.setVersao(rs.getString("versao"));
            pacote.setDependencias(rs.getString("dependencias"));
            pacote.setDescricao(rs.getString("descricao"));
            pacote.setCategoria(new PacotesCategoriaDAO().selecionar(rs.getInt("categoria")));
            pacote.setAtivo(rs.getBoolean("ativo"));
            lista.add(pacote);
            
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }

}
