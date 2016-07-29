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

import br.com.brunotonia.VO.Remocao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RemocaoDAO {

    public void adicionar(Remocao r) throws Exception {
        String sql = "INSERT INTO remocao "
                + "(\"pacote\", \"ativo\")"
                + " VALUES "
                + "(?, ?)";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setInt(1, r.getPacote().getId());
        ps.setBoolean(2, r.getAtivo());

        ps.execute();
        ps.close();
        cnn.close();
    }
    
    public Remocao selecionar(Integer id) throws Exception {
        Remocao remocao = null;
        String sql = "SELECT * FROM remocao WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {

            remocao = new Remocao();
            remocao.setId(rs.getInt("id"));
            remocao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            remocao.setAtivo(rs.getBoolean("ativo"));

        }
        rs.close();
        ps.close();
        cnn.close();
        return remocao;
    }
    
    public void ativarDesativar (Remocao r) throws Exception {
        String sql = "UPDATE remocao SET "
                + " ativo = ?,"
                + " WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setBoolean(1, !r.getAtivo());
        ps.setInt(2, r.getPacote().getId());

        ps.execute();
        ps.close();
        cnn.close();
    }
    
    
    public List<Remocao> listar() throws Exception {
        String sql = "SELECT * FROM remocao ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Remocao> lista = new ArrayList<Remocao>();
        while (rs.next()) {
            Remocao remocao = new Remocao();
            remocao.setId(rs.getInt("id"));
            remocao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            lista.add(remocao);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<Remocao> listar(Integer id) throws Exception {
        String sql = "SELECT * FROM remocao WHERE id > ? AND ativo = ? ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setBoolean(2, true);
        ResultSet rs = ps.executeQuery();
        List<Remocao> lista = new ArrayList<Remocao>();
        while (rs.next()) {
            Remocao remocao = new Remocao();
            remocao.setId(rs.getInt("id"));
            remocao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            lista.add(remocao);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }

}
