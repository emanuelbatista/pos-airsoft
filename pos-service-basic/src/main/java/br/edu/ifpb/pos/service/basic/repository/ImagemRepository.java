/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.repository;

import br.edu.ifpb.pos.entity.Imagem;
import javax.persistence.TypedQuery;

/**
 *
 * @author emanuel
 */
public class ImagemRepository extends JpaRepository<Imagem, Long>{
    
    public Byte[] getImagemDado(Long idImagem){
        TypedQuery<Byte[]> query=super.entityManager.createQuery("SELECT i.imagem FROM Imagem i WHERE i.id=:id", Byte[].class);
        query.setParameter("id", idImagem);
        return query.getSingleResult();
    }
}
