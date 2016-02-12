/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service;

import br.edu.ifpb.pos.entity.Jogo;
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
    
    public void addMembroAoJogo(Long idJogo,Long idMembro) throws RemoteException;
    
    public List<Jogo> listJogos(Integer numPagina) throws RemoteException;
}
