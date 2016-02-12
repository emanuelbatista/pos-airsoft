/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.entity;

import br.edu.ifpb.pos.entity.convert.ConvertDate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author emanuel
 */
@Entity
public class Jogo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "O objetivo do jogo não pode fica vazio")
    private String objetivo;
    private String enredo;
    private String missao;
    @Convert(converter = ConvertDate.class)
    private LocalDateTime local;
    @Enumerated(EnumType.ORDINAL)
    private JogoEstado estado;
    private String horario;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private byte[] foto;
    @OneToOne
    private Album album;
    @ManyToMany
    private List<Membro> membros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getEnredo() {
        return enredo;
    }

    public void setEnredo(String enredo) {
        this.enredo = enredo;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public LocalDateTime getLocal() {
        return local;
    }

    public void setLocal(LocalDateTime local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public JogoEstado getEstado() {
        return estado;
    }

    public void setEstado(JogoEstado estado) {
        this.estado = estado;
    }
    
    
    
    
}
