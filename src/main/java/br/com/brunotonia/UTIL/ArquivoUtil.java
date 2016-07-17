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
import org.apache.commons.io.FileUtils;
import org.tukaani.xz.XZInputStream;

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

    public File descompactarArquivoXZ(File arquivo_xz) {
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
    }

}