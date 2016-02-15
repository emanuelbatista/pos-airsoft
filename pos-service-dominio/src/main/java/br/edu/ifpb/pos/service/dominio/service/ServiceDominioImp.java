/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.dominio.service;

import br.edu.ifpb.pos.entity.ConfirmeMembroJogo;
import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.JogoEstado;
import br.edu.ifpb.pos.entity.Membro;
import br.edu.ifpb.pos.service.ServiceBasic;
import br.edu.ifpb.pos.service.ServiceDominio;
import br.edu.ifpb.pos.service.dominio.validation.Validacao;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.validation.ConstraintViolation;

/**
 *
 * @author emanuel
 */
@WebService(name = "ServiceDominio", serviceName = "ServiceDominio", targetNamespace = "http://service.pos.ifpb.edu.br/")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ServiceDominioImp implements ServiceDominio {
    
    private ServiceBasic serviceBasic;
    
    public ServiceDominioImp() throws RemoteException {
        
        try {
            this.serviceBasic = ServiceBasicFactory.getInstance();
        } catch (MalformedURLException ex) {
            throw new RemoteException(ex.getMessage());
        }
    }
    
    @Override
    public void addJogo(Jogo jogo) throws RemoteException {
        List<ConstraintViolation<Jogo>> violations = Validacao.validar(jogo);
        if (!violations.isEmpty()) {
            throw new RemoteException(violations.get(0).getMessage());
        }
        jogo.setEstado(JogoEstado.ATIVO);
        serviceBasic.addJogo(jogo);
    }
    
    @Override
    public List<Jogo> listJogos(Integer numPagina) throws RemoteException {
        return serviceBasic.findJogoPaginado(numPagina);
    }
    
    @Override
    public void addMembroAoJogo(Long idJogo, Long idMembro) throws RemoteException {
        serviceBasic.addMembroAoJogo(idJogo, idMembro);
    }
    
    @Override
    public Jogo getJogo(Long id) throws RemoteException {
        return serviceBasic.findJogo(id);
    }
    
    @Override
    public void addMembro(Membro membro) throws RemoteException {
        List<ConstraintViolation<Membro>> violations = Validacao.validar(membro);
        if (!violations.isEmpty()) {
            throw new RemoteException(violations.get(0).getMessage());
        }
        serviceBasic.addMembro(membro);
    }
    
    @Override
    public List<Membro> listAllMembro() throws RemoteException {
        return serviceBasic.findAllMembro();
    }
    
    @Override
    public List<Membro> listMembrosJogoNaoCorrespondente(Long idJogo, String pesquisa) throws RemoteException {
        return serviceBasic.findMembrosJogoNaoCorrespondente(idJogo, pesquisa);
    }

    @Override
    public List<Membro> listMembroJogo(Long idJogo) throws RemoteException {
        return serviceBasic.findMembrosJogo(idJogo);
    }

    @Override
    public void enviarConfirmacaoMembroJogo(Long idJogo,Long idMembro) throws RemoteException {
        Membro membro=serviceBasic.findMembro(idMembro);
        
        //
        ConfirmeMembroJogo confirmeMembroJogo=new ConfirmeMembroJogo();
        Jogo jogo=serviceBasic.findJogo(idJogo);
        confirmeMembroJogo.setJogo(jogo);
        confirmeMembroJogo.setMembro(membro);
        //
        
    }
    
}
