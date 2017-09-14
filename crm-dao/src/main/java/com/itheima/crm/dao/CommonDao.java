package com.itheima.crm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 13718 on 2017/9/12.
 */
public interface CommonDao<T> {

    void save(T entity);
    void update(T entity);
    T findObjectByID(Serializable id);
    void deleteObjectByIds(Serializable... ids);
    void deleteObjectByCollection(List<T> list);
    List<T> findCollectionByConditionNoPage(String condition, Object[] params, Map<String, String> orderby);

}
