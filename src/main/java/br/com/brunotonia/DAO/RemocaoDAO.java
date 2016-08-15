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
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, r.getPacote().getId());
        ps.setBoolean(2, true);
        ps.execute();
        ps.close();
        cnn.close();
    }

    public Remocao selecionar(Integer id) throws Exception {
        String sql = "SELECT * FROM remocao WHERE id = ?";
        Remocao remocao = null;
        try {
            Connection cnn = PostgresqlConnect.getInstance().getConnection();
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
        } catch (Exception e) {

        }
        return remocao;
    }

    public void ativarDesativar(Remocao r) {
        try {
            String sql = "UPDATE remocao SET  ativo = ?, WHERE id = ?";
            Connection cnn = PostgresqlConnect.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setBoolean(1, !r.getAtivo());
            ps.setInt(2, r.getId());
            ps.execute();
            ps.close();
            cnn.close();
        } catch (Exception e) {

        }
    }

    public List<Remocao> listar() {
        String sql = "SELECT * FROM remocao ORDER BY id ";
        List<Remocao> lista = new ArrayList<Remocao>();
        try {
            Connection cnn = PostgresqlConnect.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Remocao remocao = new Remocao();
                remocao.setId(rs.getInt("id"));
                remocao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
                remocao.setAtivo(rs.getBoolean("ativo"));
                lista.add(remocao);
            }
            rs.close();
            ps.close();
            cnn.close();
        } catch (Exception e) {

        }
        return lista;
    }

    public List<Remocao> listar(Integer id) {
        String sql = "SELECT * FROM remocao WHERE id > ? AND ativo = ? ORDER BY id ";
        List<Remocao> lista = new ArrayList<Remocao>();
        try {
            Connection cnn = PostgresqlConnect.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBoolean(2, true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Remocao remocao = new Remocao();
                remocao.setId(rs.getInt("id"));
                remocao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
                remocao.setAtivo(rs.getBoolean("ativo"));
                lista.add(remocao);
            }
            rs.close();
            ps.close();
            cnn.close();
        } catch (Exception e) {

        }
        return lista;
    }

}
