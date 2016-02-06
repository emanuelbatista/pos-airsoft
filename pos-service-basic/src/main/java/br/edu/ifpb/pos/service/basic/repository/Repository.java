/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

/**
 *
 * @author emanuel
 * @param <T>
 * @param <K>
 */
public interface Repository<T,K> {
    
    public void add(T t);
    
    public T findOne(Class<T> clazz,K k);
    
    public void edit(T t);
    
    public void remove(T t);
    
}
