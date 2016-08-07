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

import br.com.brunotonia.VO.PacotesCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacotesCategoriaDAO {

    public void adicionar(PacotesCategoria p) throws Exception {
        String sql = "INSERT INTO pacotes_categoria (\"categoria\") VALUES (?)";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, p.getCategoria());
        ps.execute();
        ps.close();
        cnn.commit();        
        cnn.close();
    }

    public PacotesCategoria selecionar(Integer id) throws Exception {
        PacotesCategoria pctCategoria = null;
        String sql = "SELECT * FROM pacotes_categoria WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pctCategoria = new PacotesCategoria(rs.getInt("id"), rs.getString("categoria"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return pctCategoria;
    }

    public PacotesCategoria selecionar(String categoria) throws Exception {
        PacotesCategoria pctCategoria = null;
        String sql = "SELECT * FROM pacotes_categoria WHERE categoria = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, categoria.toLowerCase());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pctCategoria = new PacotesCategoria(rs.getInt("id"), rs.getString("categoria"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return pctCategoria;
    }

    public List<PacotesCategoria> listar() throws Exception {
        String sql = "SELECT * FROM pacotes_categoria ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<PacotesCategoria> lista = new ArrayList<PacotesCategoria>();
        while (rs.next()) {
            PacotesCategoria p = new PacotesCategoria(rs.getInt("id"), rs.getString("categoria"));
            lista.add(p);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }

}
