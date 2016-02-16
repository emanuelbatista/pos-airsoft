/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service;

import br.edu.ifpb.pos.entity.ConfirmeMembroJogo;
import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.Membro;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author emanuel
 */
@WebService
public interface ServiceBasic {
    
    public void addJogo(Jogo jogo) throws RemoteException;
    
    public void atualizarJogo(Jogo jogo) throws RemoteException;
    
    public Jogo findJogo(Long id) throws RemoteException;
    
    public void addConfirmacaoMembroJogo(ConfirmeMembroJogo confirmeMembroJogo) throws RemoteException;
    
    public void removeConfirmacaoMembroJogo(ConfirmeMembroJogo confirmeMembroJogo) throws RemoteException;
    
    public ConfirmeMembroJogo getConfirmeMembroJogo(String token) throws RemoteException;
    
    public List<Membro> findMembrosJogo(Long idJogo) throws RemoteException;
    
    public void addMembroAoJogo(Long idJogo, Long idMembro) throws RemoteException;
    
    public Membro findMembro(Long id) throws RemoteException;
    
    public List<Membro> findMembrosJogoNaoCorrespondente(Long idJogo,String pesquisa) throws RemoteException;
    
    public List<Membro> findAllMembro() throws RemoteException;
    
    public void addMembro(Membro membro) throws RemoteException;
    
    public List<Jogo> findJogoPaginado(Integer numPagina) throws RemoteException;
}
