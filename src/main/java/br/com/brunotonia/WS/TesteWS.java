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

//import br.com.brunotonia.BO.VersaoBO;
//import br.com.brunotonia.VO.Versao;
//import javax.ws.rs.GET;
import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

@Path("/testes")
public class TesteWS {
    
    /*@GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String testes() {
        System.err.print("Testes/\n"
                + "\t- sf - testa o sessionFactory\n"
                + "\t- session - testa a session\n"
                + "\n");
        return "Testes/\n"
                + "\t- sf - testa o sessionFactory\n"
                + "\t- session - testa a session\n"
                + "\n";
    }*/
    
    /*@Path("/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versao() {
        VersaoBO versaoBO = new VersaoBO();
        Versao v = versaoBO.selecionar();
        if (v == null) {
            return "não deu certo";
        } else {
            return v.toString();
        }
    }*/
    
}
