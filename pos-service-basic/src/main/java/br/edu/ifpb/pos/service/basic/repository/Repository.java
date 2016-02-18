/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

/**
 *Interface que possui as operações básica para manipulação das entidades na base de dados
 * 
 * @author emanuel
 * @param <T>
 * @param <K>
 */
public interface Repository<T,K> {
    
    /**
     * Adiciona a entidade a base de dados
     * @param t 
     */
    public void add(T t);
    
    /**
     * Retorna a entidade de acordo com o a classe da entidade e seu ID
     * @param clazz
     * @param k
     * @return Entidade
     */
    public T findOne(Class<T> clazz,K k);
    
    /**
     * Edita as informações de uma entidade já existente
     * @param t 
     */
    public void edit(T t);
    
    /**
     * Remove a entidade na base de dados
     * @param t 
     */
    public void remove(T t);
    
}
