/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

import br.edu.ifpb.pos.entity.Imagem;
import javax.persistence.TypedQuery;

/**
 *Repositório que realiza as operações na base de dados da entidade {@link Imagem} 
 * 
 * @author emanuel
 */
public class ImagemRepository extends JpaRepository<Imagem, Long>{
    
    /**
     * Retorna o dado da imagem apartir do id da imagem
     * 
     * @param idImagem
     * @return Dado da Imagem
     */
    public Byte[] getImagemDado(Long idImagem){
        TypedQuery<Byte[]> query=super.entityManager.createQuery("SELECT i.imagem FROM Imagem i WHERE i.id=:id", Byte[].class);
        query.setParameter("id", idImagem);
        return query.getSingleResult();
    }
}
