package br.com.brunotonia.WS;

import br.com.brunotonia.BO.InstalacaoBO;
import br.com.brunotonia.BO.VersaoBO;
import br.com.brunotonia.UTIL.PacotesUtil;
import br.com.brunotonia.UTIL.RepositorioUtil;
import br.com.brunotonia.VO.Instalacao;
import br.com.brunotonia.VO.Versao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/apt-get")
public class AptGetWS {
    
    @Path("/update")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String atualizarListaPacotes() {
        long tempoInicial = System.currentTimeMillis();
        new PacotesUtil().processarListaDePacotes();
        long tempoTotal = (System.currentTimeMillis() - tempoInicial) / 1000;
        return "Tempo de execução: " + tempoTotal + " segundos";
    }

    @Path("/update/URLs")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String exibirListaURLs() {
        String aux = "";
        for (String s : new RepositorioUtil().listarURLsPacotes()) {
            aux += s + "\n";
        }
        return aux;
    }

    @Path("/install")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String instalarPacotes() {
        InstalacaoBO instalacaoBO = new InstalacaoBO();
        String resultado = "";
        List<Instalacao> lista_install = instalacaoBO.listar();
        for (Instalacao i : lista_install) {
            if (i.getPacote().getAtivo() && i.getAtivo()) {
                resultado += i.getPacote().getPacote() + " ";
            }
        }
        return resultado;
    }
    
    @Path("/install/{versao}")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String instalarPacotes(@PathParam("versao") Integer versao) {
        InstalacaoBO ij = new InstalacaoBO();
        String resultado = "";
        List<Instalacao> lista_install = ij.listar(versao);
        for (Instalacao i : lista_install) {
            if (i.getPacote().getAtivo() && i.getAtivo()) {
                resultado += i.getPacote().getPacote() + " ";
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
    
    /*@Path("/remove/{versao}")
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String removerPacotes(@PathParam("versao") Integer versao) {
        return "hummm! programar o caminho para a formatura é!\n"
                + "                                          yoda, mestre";
    }*/
    
    @Path("/remove/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoRemoverPacotes() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getRemocao().toString();
    }
    
}