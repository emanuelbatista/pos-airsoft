/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author emanuel
 */
@Entity
public class Album implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String codigoJogo;
    @ElementCollection
    @Lob
    private List<Byte[]> imagens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoJogo() {
        return codigoJogo;
    }

    public void setCodigoJogo(String codigoJogo) {
        this.codigoJogo = codigoJogo;
    }

    public List<Byte[]> getImagens() {
        return imagens;
    }

    public void setImagens(List<Byte[]> imagens) {
        this.imagens = imagens;
    }
    
    
    
}
