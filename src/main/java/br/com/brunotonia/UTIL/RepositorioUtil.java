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
package br.com.brunotonia.UTIL;

import br.com.brunotonia.BO.RepositorioBO;
import br.com.brunotonia.VO.Repositorio;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUtil {

    public List<String> listarURLsPacotes() {
        // Obtém lista de Repositorios do banco de dados
        List<Repositorio> repositorios = new RepositorioBO().listarAtivos();
        List<String> lista = new ArrayList<String>();
        String url = "";
        for (Repositorio r : repositorios) {
            // Url de exemplo
            // http://sft.if.usp.br/debian/dists/jessie/main/binary-all/Packages.xz
            String aux = r.getUrl() + "dists/" + r.getVersao() + "/";
            String[] rep = r.getRepositorios().split(" ");
            if (r.getId().equals(1)) {
                for (String rep1 : rep) {
                    lista.add(aux + rep1 + "/binary-all/Packages.xz");
                    lista.add(aux + rep1 + "/binary-i386/Packages.xz");
                }
            } else {
                for (String rep1 : rep) {
                    lista.add(aux + rep1 + "/source/Sources.xz");
                }
            }
        }
        return lista;
    }
}
