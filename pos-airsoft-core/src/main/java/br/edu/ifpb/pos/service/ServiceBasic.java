/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service;

import br.edu.ifpb.pos.entity.Album;
import br.edu.ifpb.pos.entity.ConfirmacaoMembroJogo;
import br.edu.ifpb.pos.entity.Imagem;
import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.JogoEstado;
import br.edu.ifpb.pos.entity.Membro;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;

/**
 *Interface que disponibiliza os serviços básicos (infraestrutura) da aplicação
 *
 * @author emanuel
 */
@WebService
public interface ServiceBasic {
    
    /**
     * Adiciona um novo jogo
     * @param jogo
     * @throws RemoteException 
     */
    public void addJogo(Jogo jogo) throws RemoteException;
    
    /**
     * Atualiza as informações de um jogo já existente
     * @param jogo
     * @throws RemoteException 
     */
    public void atualizarJogo(Jogo jogo) throws RemoteException;
    
    /**
     * Retorna o jogo apartir do seu ID 
     * @param id
     * @return Jogo
     * @throws RemoteException 
     */
    public Jogo findJogo(Long id) throws RemoteException;
    
    /**
     * Adiciona a confirmação do membro referente a participação do membro ao jogo
     * @param confirmeMembroJogo
     * @throws RemoteException 
     */
    public void addConfirmacaoMembroJogo(ConfirmacaoMembroJogo confirmeMembroJogo) throws RemoteException;
    
    /**
     * Remove a confirmação do membro referente a participação do membro ao jogo
     * @param confirmeMembroJogo
     * @throws RemoteException 
     */
    public void removeConfirmacaoMembroJogo(ConfirmacaoMembroJogo confirmeMembroJogo) throws RemoteException;
    
    /**
     * Retorna a confirmação do membro ao jogo apartir do TOKEN de comfirmação
     * @param token
     * @return Confirmação do Membro ao Jogo
     * @throws RemoteException 
     */
    public ConfirmacaoMembroJogo getConfirmeMembroJogo(String token) throws RemoteException;
    
    /**
     * Retorna todos os membros do jogo apartir do ID do jogo
     * @param idJogo
     * @return Lista de Membros
     * @throws RemoteException 
     */
    public List<Membro> findMembrosJogo(Long idJogo) throws RemoteException;
    
    /**
     * Adiciona o membro ao jogo apartir do ID do jogo e membro
     * @param idJogo
     * @param idMembro
     * @throws RemoteException 
     */
    public void addMembroAoJogo(Long idJogo, Long idMembro) throws RemoteException;
    
    /**
     * Retorna o Membro apartir do ID do membro
     * @param id
     * @return Membro
     * @throws RemoteException 
     */
    public Membro findMembro(Long id) throws RemoteException;
    
    /**
     * Retorna os membros que não estão contidos no jogo e que 
     * possua o email com as mesmas inicias com texto da pesquisa
     * 
     * @param idJogo - id do jogo 
     * @param pesquisa - texto para pequisar o membro apartir do email
     * @return Lista de Membros
     * @throws RemoteException 
     */
    public List<Membro> findMembrosJogoNaoCorrespondente(Long idJogo,String pesquisa) throws RemoteException;
    
    /**
     * Retorna todos os membros
     * @return Todos os membros
     * @throws RemoteException 
     */
    public List<Membro> findAllMembro() throws RemoteException;
    
    /**
     * Adiciona um novo membro
     * @param membro
     * @throws RemoteException 
     */
    public void addMembro(Membro membro) throws RemoteException;
    
    /**
     * Retorna os jogo a partir do número da páginação
     * 
     * @param numPagina
     * @return Lista de Jogos
     * @throws RemoteException 
     */
    public List<Jogo> findJogoPaginado(Integer numPagina) throws RemoteException;
    
    /**
     * Retorna os jogo a partir do número da páginação e do estado do jogo
     * @param numPagina
     * @param estado
     * @return Lista de Jogos
     * @throws RemoteException 
     */
    public List<Jogo> finJogoPaginadoEstado(Integer numPagina,JogoEstado estado) throws RemoteException;
    
    /**
     * Retorna o dado de imagem a partir do ID
     * @param idImagem
     * @return Dado da Imagem
     * @throws RemoteException 
     */
    public Byte[] getImagemDado(Long idImagem) throws RemoteException;
    
    /**
     * Retorna o Album a partir do seu ID
     * 
     * @param idAlbum
     * @return Album
     * @throws RemoteException 
     */
    public Album getAlbum(Long idAlbum) throws RemoteException;
    
    /**
     * Edita as informações de um album já existente
     * @param album
     * @throws RemoteException 
     */
    public void editAlbum(Album album) throws RemoteException;
    
    /**
     * Adiciona uma nova imagem ao Album 
     * @param idAlbum
     * @param imagem
     * @throws RemoteException 
     */
    public void addNovaImagemAlbum(Long idAlbum, Imagem imagem) throws RemoteException;
}
