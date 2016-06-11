package com.java.erp.webapp.db.interfaces.common;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java.erp.webapp.database.setup.AcademicYears;

public interface BaseDAOI {
public Object persist(Object entity) throws Exception;
public Object merge(Object entity) throws Exception;
public void flush() throws Exception;
public boolean remove(Object entity) throws Exception;
public List<?> getResultList(String query);
public Object getSingleResult(String query);
public List<?> getResultList(String query,Map<Object,Object> params);
public Object getSingleResult(String query,Map<Object,Object> params);
public List<Object[]> getNativeResultList(String query);
public Object[] getNativeSingleResult(String query);
public List<Object[]> getNativeResultList(String query,Map<Object,Object> params);
public Object[] getNativeSingleResult(String query,Map<Object,Object> params);
public Date getCurrentDate() throws Exception;
public List<AcademicYears> getActiveAcademicYear() throws Exception;

}
