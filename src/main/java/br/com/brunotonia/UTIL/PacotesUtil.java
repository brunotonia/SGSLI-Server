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

import br.com.brunotonia.BO.PacotesBO;
import br.com.brunotonia.BO.PacotesCategoriaBO;
import br.com.brunotonia.BO.VersaoBO;
import br.com.brunotonia.VO.Pacotes;
import br.com.brunotonia.VO.PacotesCategoria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacotesUtil {

    private void lerPacotes(File arquivo_txt) {

        FileInputStream stream;
        InputStreamReader reader;
        BufferedReader br;

        try {
            stream = new FileInputStream(arquivo_txt);
            reader = new InputStreamReader(stream);
            br = new BufferedReader(reader);
            String linha = br.readLine();

            // Povoa Pacotes
            PacotesBO pacotesBO = new PacotesBO();
            PacotesCategoriaBO pacotesCategoriaBO = new PacotesCategoriaBO();

            Pacotes pacote = null;
            Pacotes pct_aux = null;
            PacotesCategoria categoria = null;

            while (linha != null) {
                String valor = "";
                // Lendo o nome do Pacote!
                if (linha.startsWith("Package: ")) {
                    // Inicializo o pacote
                    pacote = new Pacotes();
                    // Leio o nome do pacote da lista de pacotes e seto o valor
                    valor = linha.substring(9).replace(" ", "").toLowerCase();
                    pacote.setPacote(valor);
                    // procura pacote do banco de dados 
                    pct_aux = pacotesBO.selecionar(valor);
                    if (pct_aux != null) {
                        pacote.setId(pct_aux.getId());
                    }
                }
                // Lendo a versao do Pacote!
                if (linha.startsWith("Version: ")) {
                    pacote.setVersao(linha.substring(9).replace(" ", "").toLowerCase());
                }
                // Lendo as dependencias do Pacote!
                if (linha.startsWith("Depends: ")) {
                    pacote.setDependencias(linha.substring(9));
                }
                // Lendo as dependencias do Pacote!
                if (linha.startsWith("Description: ")) {
                    pacote.setDescricao(linha.substring(13).toLowerCase());
                }
                // Lendo as dependencias do Pacote!
                if (linha.startsWith("Section: ")) {
                    valor = linha.substring(9).replace(" ", "").toLowerCase();
                    // Verifica e Adiciona Categoria
                    categoria = pacotesCategoriaBO.selecionar(valor);
                    if (categoria == null) {
                        categoria = new PacotesCategoria(valor);
                        pacotesCategoriaBO.adicionar(categoria);
                        categoria = pacotesCategoriaBO.selecionar(valor);
                    }
                    pacote.setCategoria(categoria);
                    // Armazena pacote
                    if (pacote.getId() == null) {
                        // Pacote não existe: Adiciona
                        pacotesBO.adicionar(pacote);
                    } else {
                        // Pacote existe: Atualiza
                        pacotesBO.atualizar(pacote);
                    }
                }
                linha = br.readLine();
            }
            arquivo_txt.delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void lerCategorias(File arquivo_txt) {
        FileInputStream stream;
        InputStreamReader reader;
        BufferedReader br;
        try {
            stream = new FileInputStream(arquivo_txt);
            reader = new InputStreamReader(stream);
            br = new BufferedReader(reader);
            String linha = br.readLine();
            PacotesCategoriaBO pcbo = new PacotesCategoriaBO();
            List<String> listaCategorias = pcbo.listarCategorias();
            for (String aux : listaCategorias) {
                System.out.println(aux);
            } 
            String valor = "";
            while (linha != null) {
                if (linha.startsWith("Section: ")) {
                    valor = linha.substring(9).replace(" ", "").toLowerCase();
                    if (!listaCategorias.contains(valor)) {
                        pcbo.adicionar(new PacotesCategoria(valor));
                    }
                }
                linha = br.readLine();
            }
            System.out.println( );
            System.out.println( );
            for (String aux : listaCategorias) {
                System.out.println(aux);
            }
            arquivo_txt.delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processarListaDePacotes() {
        List<String> lista_url = new RepositorioUtil().listarURLsPacotes();
        if (!new PacotesBO().listar().isEmpty()) {
            new PacotesBO().prepararAtualizar();
        }
        for (String url : lista_url) {
            ArquivoUtil au = new ArquivoUtil();
            System.out.println(url);
            lerPacotes(au.descompactarArquivoGZ(au.downloadArquivo(url)));
            //lerCategorias(au.descompactarArquivoGZ(au.downloadArquivo(url)));
        }
        new VersaoBO().atualizarDataListaPacotes();
        new VersaoBO().incrementarUpdate();
    }

}
