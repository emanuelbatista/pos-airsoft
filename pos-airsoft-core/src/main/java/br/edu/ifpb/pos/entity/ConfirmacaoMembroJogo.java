/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Representa a entidade que contém as informações para confirmação do membro ao jogo
 * @author emanuel
 */
@Entity
public class ConfirmacaoMembroJogo implements Serializable {
    
    @Id
    private String token; 
    @OneToOne
    private Jogo jogo;
    @OneToOne
    private Membro membro;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
    
    
}
