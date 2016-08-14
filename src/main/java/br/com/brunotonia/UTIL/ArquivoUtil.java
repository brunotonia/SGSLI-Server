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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.commons.io.FileUtils;

public class ArquivoUtil {

    public File downloadArquivo(String endereco_url) {
        File arquivo_xz = new File("/tmp/acme/pacote.xz");
        try {
            URL url = new URL(endereco_url);
            FileUtils.copyURLToFile(url, arquivo_xz);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo_xz;
    }

    /*public File descompactarArquivoXZ(File arquivo_xz) {
        File arquivo_txt = new File("/tmp/acme/pacote.txt");
        try {
            FileInputStream fin = new FileInputStream(arquivo_xz);
            BufferedInputStream in = new BufferedInputStream(fin);
            FileOutputStream out = new FileOutputStream(arquivo_txt);
            XZInputStream xzIn = new XZInputStream(in);
            final byte[] buffer = new byte[8192];
            int n = 0;
            while (-1 != (n = xzIn.read(buffer))) {
                out.write(buffer, 0, n);
            }
            out.close();
            xzIn.close();
            arquivo_xz.delete();
            return arquivo_txt;
        } catch (Exception ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }*/
    
    public File descompactarArquivoGZ(File arquivo_gz) {
        File arquivo_txt = new File("/tmp/acme/pacote.txt");
        try {
            FileInputStream fin = new FileInputStream(arquivo_gz);
            BufferedInputStream in = new BufferedInputStream(fin);
            FileOutputStream out = new FileOutputStream(arquivo_txt);
            GZIPInputStream gzIn = new GZIPInputStream(in);
            final byte[] buffer = new byte[8192];
            int n = 0;
            while ((n = gzIn.read(buffer)) > 0) {
        	out.write(buffer, 0, n);
            }
            out.close();
            gzIn.close();
            arquivo_gz.delete();
            return arquivo_txt;
        } catch (Exception ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    

}