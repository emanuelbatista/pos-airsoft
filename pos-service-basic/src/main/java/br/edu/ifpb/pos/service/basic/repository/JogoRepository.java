/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

import br.edu.ifpb.pos.entity.Jogo;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author emanuel
 */
public class JogoRepository extends JpaRepository<Jogo, Long>{
   
    public List<Jogo> findJogoPaginado(Integer numPagina){
        TypedQuery<Jogo> query=entityManager.createQuery("SELECT j FROM Jogo j", Jogo.class);
        query=query.setMaxResults(5).setFirstResult((numPagina*5)-4);
        return query.getResultList();
    }
    
}
