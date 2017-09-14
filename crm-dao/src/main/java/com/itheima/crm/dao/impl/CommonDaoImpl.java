package com.itheima.crm.dao.impl;

import com.itheima.crm.dao.CommonDao;
import com.itheima.crm.utils.TUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 13718 on 2017/9/12.
 */
public class CommonDaoImpl<T> extends HibernateDaoSupport implements CommonDao<T> {

    Class entityClass = TUtils.getActualType(this.getClass());

    @Resource(name = "sessionFactory")
    public void setDi(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }


    @Override
    public void update(Object entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public T findObjectByID(Serializable id) {
        return (T) this.getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public void deleteObjectByIds(Serializable... ids) {
        if (ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                Object entity = this.findObjectByID(id);
                this.getHibernateTemplate().delete(entity);
            }
        }
    }

    @Override
    public void deleteObjectByCollection(List list) {
        this.getHibernateTemplate().deleteAll(list);
    }

    @Override
    public List findCollectionByConditionNoPage(String condition, final Object[] params, Map<String, String> orderby) {
        String hql = "from " + entityClass.getSimpleName() + " o where 1=1";
        String orderbyCondition = this.orderbyHql(orderby);
        final String finalHql = hql + condition + orderbyCondition;

        List<T> list = this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
            @Override
            public List<T> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(finalHql);
                if (params!= null && params.length>0){
                    for (int i=0;i<params.length;i++){
                        query.setParameter(i,params[i]);
                    }
                }
                return query.list();
            }
        });
        return list;
    }

    /**
     * 将Map集合中存放的字段排序，组织成
     * ORDER BY o.textDate ASC,o.textName DESC
     */
    private String orderbyHql(Map<String, String> orderby) {
        StringBuffer buffer = new StringBuffer("");
        if (orderby != null && orderby.size() > 0) {
            buffer.append(" ORDER BY ");
            for (Map.Entry<String, String> map : orderby.entrySet()) {
                buffer.append(map.getKey() + " " + map.getValue() + ",");
            }
            //在循环后，删除最后一个逗号
            buffer.deleteCharAt(buffer.length() - 1);
        }

        return buffer.toString();

    }
}