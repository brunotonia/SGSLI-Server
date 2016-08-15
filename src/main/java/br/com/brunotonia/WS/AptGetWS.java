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

import br.com.brunotonia.BO.InstalacaoBO;
import br.com.brunotonia.BO.RemocaoBO;
import br.com.brunotonia.BO.VersaoBO;
//import br.com.brunotonia.UTIL.PacotesUtil;
//import br.com.brunotonia.UTIL.RepositorioUtil;
import br.com.brunotonia.VO.Instalacao;
import br.com.brunotonia.VO.Remocao;
import br.com.brunotonia.VO.Versao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/apt-get")
public class AptGetWS {

    /*@Path("/update")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String atualizarListaPacotes() {
        long tempoInicial = System.currentTimeMillis();
        new PacotesUtil().processarListaDePacotes();
        long tempoTotal = (System.currentTimeMillis() - tempoInicial) / 1000;
        return "Tempo de execução: " + tempoTotal + " segundos";
    }*/

    /*@Path("/update/URLs")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String exibirListaURLs() {
        String aux = "";
        for (String s : new RepositorioUtil().listarURLsPacotes()) {
            aux += s + "\n";
        }
        return aux;
    }*/

    @Path("/update/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoUpdate() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getUpdate().toString();
    }

    /*@Path("/install")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String instalarPacotes() {
        InstalacaoBO instalacaoBO = new InstalacaoBO();
        String resultado = "";
        List<Instalacao> lista_install = instalacaoBO.listarAtivos(0);
        for (Instalacao i : lista_install) {
            if (i.getPacote().getAtivo()) {
                resultado = resultado + i.getPacote().getPacote() + " ";
            }
        }
        return resultado;
    }*/
    @Path("/install/{versao}")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String instalarPacotes(@PathParam("versao") Integer versao) {
        String resultado = "";
        List<Instalacao> lista_install = new InstalacaoBO().listarAtivos(versao);
        for (Instalacao i : lista_install) {
            if (i.getPacote().getAtivo() && i.getAtivo()) {
                resultado = i.getPacote() + " " + resultado;
            }
        }
        return resultado;
    }

    @Path("/install/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoInstalarPacotes() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getInstalacao().toString();
    }

    /*@Path("/remove")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String removerPacotes() {
        RemocaoJpaController ij = new RemocaoJpaController(emf);
        String resultado = "";
        List<Remocao> lista_remove = ij.findRemocaoEntities();
        for (Remocao r : lista_remove) {
            if (r.getPacote().getAtivo() && r.getAtivo()) {
                resultado += r.getPacote().getPacote() + " ";
            }
        }
        return resultado;
    }*/
    @Path("/remove/{versao}")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String removerPacotes(@PathParam("versao") Integer versao) {
        RemocaoBO remocaoBO = new RemocaoBO();
        String resultado = "";
        List<Remocao> lista_remove = remocaoBO.listar(versao);
        for (Remocao r : lista_remove) {
            if (r.getPacote().getAtivo()) {
                resultado += r.getPacote().getPacote() + " ";
            }
        }
        return resultado;
    }

    @Path("/remove/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoRemoverPacotes() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getRemocao().toString();
    }
    
    @Path("/upgrade/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoUpgrade() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getUpgrade().toString();
    }
    
    @Path("/dist-upgrade/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoDistUpgrade() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getDistUpgrade().toString();
    }

}
