/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service;

import br.edu.ifpb.pos.entity.Album;
import br.edu.ifpb.pos.entity.Imagem;
import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.JogoEstado;
import br.edu.ifpb.pos.entity.Membro;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author emanuel
 */
@WebService
public interface ServiceDominio {
    
    public void addJogo(Jogo jogo) throws RemoteException;
    
    public void mudarEstadoJogo(Long idJogo,JogoEstado estado) throws RemoteException;
    
    public void addMembro(Membro membro) throws RemoteException;
    
    public List<Membro> listAllMembro() throws RemoteException;
    
    public List<Membro> listMembrosJogoNaoCorrespondente(Long idJogo,String pesquisa) throws RemoteException;
    
    public void enviarConfirmacaoMembroJogo(Long idJogo,Long idMembro) throws RemoteException;
    
    public Jogo getJogo(Long id) throws RemoteException;
    
    public boolean confirmarMembroJogo(String token) throws RemoteException;
    
    public List<Membro> listMembroJogo(Long idJogo) throws RemoteException;
    
    public Album getAlbumJogo(Long idJogo) throws RemoteException;
    
    public Byte[] getImagemDado(Long idImagem) throws RemoteException;
    
    public List<Jogo> listJogos(Integer numPagina) throws RemoteException;
    
    public Album getAlbum(Long idAlbum) throws RemoteException;
    
    public void modificarNomeAlbum(Long idAlbum,String nome) throws RemoteException;
    
    public void addNovaImagemAlbum(Long idAlbum,Imagem imagem) throws RemoteException;
}
