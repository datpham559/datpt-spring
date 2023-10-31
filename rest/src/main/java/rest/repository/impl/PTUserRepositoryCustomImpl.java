package rest.repository.impl;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import rest.entity.PTUser;
import rest.repository.PTUserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PTUserRepositoryCustomImpl implements PTUserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public PTUser getOnePTUser(Long id) {
        StringBuilder sql = new StringBuilder("select * from PTUser");
        Query query = entityManager.createNativeQuery(sql.toString());
        NativeQueryImpl nativeQuery = (NativeQueryImpl) query;
        nativeQuery.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List<Map<String,Object>> result = nativeQuery.getResultList();
        StringBuilder insert = new StringBuilder();
        StringBuilder values = new StringBuilder();
        insert.append("insert into (");
        values.append(") values(");
        Object[] arr = result.get(0).keySet().toArray();
        for (Object a : arr){
            insert.append(a+",");
        }
        for (Map<String,Object> r : result){
            if (result.indexOf(r) != result.size() -1 ){
                r.forEach((key,value) ->{
                    values.append(r.get(key)+",");
                });
            }else {
                r.forEach((key,value) ->{
                    values.append(r.get(key)+"),(");
                });
            }
        }


        return null;
    }
}
