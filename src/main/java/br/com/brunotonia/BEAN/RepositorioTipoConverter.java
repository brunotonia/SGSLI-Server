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

import br.com.brunotonia.BO.RepositorioTipoBO;
import br.com.brunotonia.VO.RepositorioTipo;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name="repositorioTipoConverter")
public class RepositorioTipoConverter implements Converter {

    private RepositorioTipoBO repositorioTipoBO;
 
    @Override
    public RepositorioTipo getAsObject(FacesContext context, UIComponent component, String value) {
        return repositorioTipoBO.selecionar(Integer.valueOf(value));
    }
 
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((RepositorioTipo)value).getId().toString();
    }

}
