/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

import br.edu.ifpb.pos.entity.Membro;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *Repositório que realiza as operações na base de dados da entidade {@link Membro} 
 * 
 * @author emanuel
 */
public class MembroRepository extends JpaRepository<Membro, Long>{
    
    /**
     * Retorna todos os membros 
     * 
     * @return Lista de Membros
     */
    public List<Membro> findAll(){
        TypedQuery<Membro> query=super.entityManager.createQuery("SELECT m FROM Membro m",Membro.class);
        return query.getResultList();
    }
}
