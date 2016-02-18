/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Representa a entidade que contém as informações de uma imagem
 * @author emanuel
 */
@Entity
public class Imagem implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private Byte[] imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte[] getImagem() {
        return imagem;
    }

    public void setImagem(Byte[] imagem) {
        this.imagem = imagem;
    }

    
    
    
    
    
    
    
}
