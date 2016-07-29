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
package br.com.brunotonia.WS;

import br.com.brunotonia.BO.RepositorioBO;
import br.com.brunotonia.BO.RepositorioSecurityBO;
import br.com.brunotonia.BO.VersaoBO;
import br.com.brunotonia.UTIL.RepositorioUtil;
import br.com.brunotonia.VO.Repositorio;
import br.com.brunotonia.VO.RepositorioSecurity;
import br.com.brunotonia.VO.Versao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/etc/apt/sources.list")
public class SourcesListWS {

    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String gerarSourcesList() {
        RepositorioBO repositorioBO = new RepositorioBO();
        List<Repositorio> lista = repositorioBO.listarAtivos();
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        if (lista.isEmpty() || versao == null) {
            return "ERRO";
        } else {
            String resultado = "#SGSLI - Gerado automaticamente.\n#Versão " + versao.getSources().toString() + "\n\n";
            for (Repositorio repositorio : lista) {
                resultado += repositorio.toString() + " \n";
            }
            resultado += "\n";
            RepositorioSecurityBO repositorioSecurityBO = new RepositorioSecurityBO();
            List<RepositorioSecurity> listaSecurity = repositorioSecurityBO.listarAtivos();
            for (RepositorioSecurity repositorio : listaSecurity) {
                resultado += repositorio.toString() + " \n";
            }
            return resultado;
        }
    }

    @Path("/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoSourcesList() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getSources().toString();
    }

    @Path("/urls")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String urlSourcesList() {
        String s = "";
        RepositorioUtil p = new RepositorioUtil();
        for (String aux : p.listarURLsPacotes()) {
            s += aux + "\n";
        }
        return s;
    }
    
}
