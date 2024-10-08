package org.example.wshop;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@FacesConverter(forClass = ConvertibleEntity.class)
public class EntityConverter<T> implements Converter<ConvertibleEntity<T>> {
    @PersistenceContext
    EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public ConvertibleEntity<T> getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        Class<ConvertibleEntity<T>> entityType = (Class<ConvertibleEntity<T>>) component.getValueExpression("value").getType(context.getELContext());
        Class<?> idType = em.getMetamodel().entity(entityType).getIdType().getJavaType();
        Converter<?> idConverter = context.getApplication().createConverter(idType);
        Object id = idConverter.getAsObject(context, component, value);
        return em.find(entityType, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getAsString(FacesContext context, UIComponent component, ConvertibleEntity<T> value) {
        if (value == null) {
            return "";
        }

        T id = value.getId();
        Converter<T> idConverter = context.getApplication().createConverter(id.getClass());
        return idConverter.getAsString(context, component, id);
    }
}
