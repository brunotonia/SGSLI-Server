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
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, p.getPacote().getId());
        ps.setBoolean(2, p.getAtivo());
        ps.execute();
        ps.close();
        //cnn.commit();
        cnn.close();
    }

    public Instalacao selecionar(Integer id) throws Exception {
        Instalacao instalacao = null;
        String sql = "SELECT * FROM instalacao WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
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

    public void ativarDesativar(Instalacao i) throws Exception {
        String sql = "UPDATE instalacao SET ativo = ? WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, !i.getAtivo());
        System.out.println(i.getAtivo());
        ps.setInt(2, i.getId());
        ps.execute();
        ps.close();
        //cnn.commit();
        cnn.close();
    } 

    public List<Instalacao> listar() {
        String sql = "SELECT * FROM instalacao ORDER BY id ";
        List<Instalacao> lista = new ArrayList<Instalacao>();
        try {
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Instalacao instalacao = new Instalacao();
            instalacao.setId(rs.getInt("id"));
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            instalacao.setAtivo(rs.getBoolean("ativo"));
            lista.add(instalacao);
        }
        rs.close();
        ps.close();
        cnn.close();
        } catch (Exception e) {
            
        }
        return lista;
    }

    public List<Instalacao> listarAtivos(Integer id) throws Exception {
        String sql = "SELECT * FROM instalacao WHERE id > ? AND ativo = ? ORDER BY id";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setBoolean(2, true);
        ResultSet rs = ps.executeQuery();
        List<Instalacao> lista = new ArrayList<Instalacao>();
        while (rs.next()) {
            Instalacao instalacao = new Instalacao();
            instalacao.setId(rs.getInt("id"));
            instalacao.setPacote(new PacotesDAO().selecionar(rs.getInt("pacote")));
            instalacao.setAtivo(rs.getBoolean("ativo"));
            lista.add(instalacao);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }

}
