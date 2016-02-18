/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.eclipse.persistence.exceptions.TransactionException;

/**
 *Repositório genérico que realiza as operações na base de dados sobre as entidades
 * 
 * @author emanuel
 * @param <T>
 * @param <K>
 */
public class JpaRepository<T, K> implements Repository<T, K> {

    protected EntityManager entityManager;

    public JpaRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pos-airsoft-pesistence");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void add(T t) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.flush();
            entityManager.persist(t);
            transaction.commit();
        } catch (TransactionException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public T findOne(Class<T> clazz, K k) {
        return entityManager.find(clazz, k);
    }

    @Override
    public void edit(T t) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.flush();
            entityManager.merge(t);
            transaction.commit();
        } catch (TransactionException e) {
             if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void remove(T t) {
          EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.flush();
            entityManager.remove(entityManager.merge(t));
            transaction.commit();
        } catch (TransactionException e) {
             if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }


}
