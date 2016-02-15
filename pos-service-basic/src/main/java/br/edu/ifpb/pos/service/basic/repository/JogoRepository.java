/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.Membro;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author emanuel
 */
public class JogoRepository extends JpaRepository<Jogo, Long>{
   
    public List<Jogo> findJogoPaginado(Integer numPagina){
        TypedQuery<Jogo> query=entityManager.createQuery("SELECT j FROM Jogo j", Jogo.class);
        query=query.setMaxResults(5).setFirstResult((numPagina*5)-5);
        return query.getResultList();
    }
    
    public List<Membro> findMembrosJogoNaoCorrespondente(Long idJogo,String nomeOuEmail){
        TypedQuery<Membro> query=super.entityManager.createNamedQuery("list.membros.nao.correspondente", Membro.class);
        query.setMaxResults(5);
        query.setParameter("id", idJogo);
        query.setParameter("pesquisa", nomeOuEmail+"%");
        return query.getResultList();
    }
    
    public List<Membro> findMembrosJogo(Long idJogo){
        TypedQuery<Membro> query=super.entityManager.createQuery("SELECT m FROM Jogo j JOIN j.membros m WHERE j.id=:id", Membro.class);
        query.setParameter("id", idJogo);
        return query.getResultList();
    }
}
