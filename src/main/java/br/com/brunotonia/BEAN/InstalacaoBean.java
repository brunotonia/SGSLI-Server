/*
 * Copyright (C) 2016 bruno
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
package br.com.brunotonia.BEAN;

import br.com.brunotonia.BO.InstalacaoBO;
import br.com.brunotonia.VO.Instalacao;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "instalacaoBean")
public class InstalacaoBean {
    
    private Instalacao usuario = new Instalacao();
    private List<Instalacao> listaUsuarios = new InstalacaoBO().listar();
    
}
