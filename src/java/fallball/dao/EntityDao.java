/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallball.dao;

import java.util.List;

/**
 *
 * @author Alumno-CT
 * @param <T> the target entity for CRUD operations
 */
public interface EntityDao<T> {
    
    boolean create(T toInsert);
    boolean update(T toUpdate);
    boolean delete(Object id);
    T find(Object id);
    List<T> findAll();
    
}
