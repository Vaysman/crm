package ru.spb.lanton.soft.ag.crm.web.model.modules.segment;

import java.util.Map;

/**
 * Интерфейс для получения карты с ключем и значение.
 * @author antoxa
 */
public interface GetMap {
    
    void setKey(String key);
    
    String getKey();
    
    void setValue(String value);
    
    String getValue();
    
}
