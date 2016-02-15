/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic.service;

import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.Membro;
import br.edu.ifpb.pos.service.ServiceBasic;
import br.edu.ifpb.pos.service.basic.repository.JogoRepository;
import br.edu.ifpb.pos.service.basic.repository.MembroRepository;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author emanuel
 */
@WebService(name = "ServiceBasic", serviceName = "ServiceBasic", targetNamespace = "http://service.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ServiceBasicImp implements ServiceBasic {

    private final JogoRepository jogoRepository;
    private final MembroRepository membroRepository;

    public ServiceBasicImp() {
        this.jogoRepository = new JogoRepository();
        this.membroRepository = new MembroRepository();
    }

    @Override
    public void addJogo(Jogo jogo) {
        jogoRepository.add(jogo);
    }

    @Override
    public void addMembro(Membro membro) {
        membroRepository.add(membro);
    }

    @Override
    public List<Jogo> findJogoPaginado(Integer numPagina) {
        return jogoRepository.findJogoPaginado(numPagina);
    }

    @Override
    public Jogo findJogo(Long id) throws RemoteException {
        return jogoRepository.findOne(Jogo.class, id);
    }

    @Override
    public Membro findMembro(Long id) throws RemoteException {
        return membroRepository.findOne(Membro.class, id);
    }

    @Override
    public void atualizarJogo(Jogo jogo) throws RemoteException {
        jogoRepository.edit(jogo);
    }

    @Override
    public List<Membro> findAllMembro() throws RemoteException {
       return membroRepository.findAll();
    }

    @Override
    public List<Membro> findMembrosJogoNaoCorrespondente(Long idJogo,String pesquisa) throws RemoteException {
        return jogoRepository.findMembrosJogoNaoCorrespondente(idJogo, pesquisa);
    }

    @Override
    public void addMembroAoJogo(Long idJogo, Long idMembro) throws RemoteException {
        Jogo jogo=jogoRepository.findOne(Jogo.class, idJogo);
        Membro membro=membroRepository.findOne(Membro.class, idMembro);
        jogo.getMembros().add(membro);
        jogoRepository.edit(jogo);
    }

    @Override
    public List<Membro> findMembrosJogo(Long idJogo) throws RemoteException {
        return jogoRepository.findMembrosJogo(idJogo);
    }
}
