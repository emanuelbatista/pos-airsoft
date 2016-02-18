/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.JogoEstado;
import br.edu.ifpb.pos.entity.Membro;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *Repositório que realiza as operações na base de dados da entidade {@link Jogo} 
 * 
 * @author emanuel
 */
public class JogoRepository extends JpaRepository<Jogo, Long>{
   
    /**
     * Retonar os jogos de acordo com o número da página passado por parametro e 
     * possuindo no máximo 5 jogos
     *
     * @param numPagina
     * @return Lista de Jogo
     */
    public List<Jogo> findJogoPaginado(Integer numPagina){
        TypedQuery<Jogo> query=entityManager.createQuery("SELECT j FROM Jogo j", Jogo.class);
        query=query.setMaxResults(5).setFirstResult((numPagina*5)-5);
        return query.getResultList();
    }
    
    /**
     * Retorna todos os membros que não está contido como membro do jogo passado atráves do seu ID e
     * de acordo com a pesquisa do email do membro passado.
     * @param idJogo
     * @param email
     * @return Lista de Membros
     */
    public List<Membro> findMembrosJogoNaoCorrespondente(Long idJogo,String email){
        TypedQuery<Membro> query=super.entityManager.createNamedQuery("list.membros.nao.correspondente", Membro.class);
        query.setMaxResults(5);
        query.setParameter("id", idJogo);
        query.setParameter("pesquisa", email+"%");
        return query.getResultList();
    }
    
    /**
     * Retorna todos os membros do jogo apartir do ID do jogo
     * 
     * @param idJogo
     * @return Lista de Membro
     */
    public List<Membro> findMembrosJogo(Long idJogo){
        TypedQuery<Membro> query=super.entityManager.createQuery("SELECT m FROM Jogo j JOIN j.membros m WHERE j.id=:id", Membro.class);
        query.setParameter("id", idJogo);
        return query.getResultList();
    }
    
    /**
     * Retonar os jogos de acordo com o número da página e estado do jogo passado por parametro e 
     * possuindo no máximo 5 jogos
     * 
     * @param numPagina
     * @param jogoEstado
     * @return Lista de Jogos
     */
    public List<Jogo> findJogoPaginadoEstado(Integer numPagina,JogoEstado jogoEstado){
        TypedQuery<Jogo> query=super.entityManager.createQuery("SELECT j FROM Jogo j WHERE j.estado=:estado", Jogo.class);
        query.setFirstResult((numPagina*5)-5).setMaxResults(5);
        query.setParameter("estado", jogoEstado);
        //
        return query.getResultList();
    }
}
