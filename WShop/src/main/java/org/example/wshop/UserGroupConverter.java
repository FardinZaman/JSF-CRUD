package org.example.wshop;

import jakarta.faces.FacesException;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import org.example.wshop.model.UserGroup;
import org.example.wshop.service.UserGroupService;

@FacesConverter(forClass= UserGroup.class, managed=true)
public class UserGroupConverter implements Converter<UserGroup> {

    @Inject
    private UserGroupService userGroupService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, UserGroup userGroup) {
        if (userGroup == null) {
            return "";
        }

        if(userGroup.getId() != null) {
            return userGroup.getId().toString();
        }
        else {
            throw new ConverterException(new FacesException("User group id is null"));
        }
    }

    @Override
    public UserGroup getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        if(id == null || id.isEmpty()) {
            return null;
        }

        try {
            return userGroupService.findById(Integer.valueOf(id));
        }
        catch(NumberFormatException e) {
            throw new ConverterException(e);
        }
    }
}
