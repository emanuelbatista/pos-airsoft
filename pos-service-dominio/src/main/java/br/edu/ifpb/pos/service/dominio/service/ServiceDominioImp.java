/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.dominio.service;

import br.edu.ifpb.pos.entity.Album;
import br.edu.ifpb.pos.entity.ConfirmacaoMembroJogo;
import br.edu.ifpb.pos.entity.Imagem;
import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.JogoEstado;
import br.edu.ifpb.pos.entity.Membro;
import br.edu.ifpb.pos.service.ServiceBasic;
import br.edu.ifpb.pos.service.ServiceDominio;
import br.edu.ifpb.pos.service.dominio.service.email.Mail;
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
        jogo.setAlbum(new Album());
        serviceBasic.addJogo(jogo);
    }

    @Override
    public List<Jogo> listJogos(Integer numPagina) throws RemoteException {
        return serviceBasic.findJogoPaginado(numPagina);
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
    public void enviarConfirmacaoMembroJogo(Long idJogo, Long idMembro) throws RemoteException {
        Membro membro = serviceBasic.findMembro(idMembro);
        Jogo jogo = serviceBasic.findJogo(idJogo);
        Mail mail = new Mail();
        String codigo = mail.enviarConfirmacaoMembroJogo(jogo, membro);
        //
        ConfirmacaoMembroJogo confirmeMembroJogo = new ConfirmacaoMembroJogo();
        confirmeMembroJogo.setToken(codigo);
        confirmeMembroJogo.setJogo(jogo);
        confirmeMembroJogo.setMembro(membro);
        serviceBasic.addConfirmacaoMembroJogo(confirmeMembroJogo);
        //

    }

    @Override
    public void mudarEstadoJogo(Long idJogo, JogoEstado estado) throws RemoteException {
        Jogo jogo = serviceBasic.findJogo(idJogo);
        jogo.setEstado(estado);
        serviceBasic.atualizarJogo(jogo);
        //
        Mail mail = new Mail();
        mail.enviarMudancaEstadoJogo(jogo, serviceBasic.findMembrosJogo(idJogo));
    }

    @Override
    public boolean confirmarMembroJogo(String token) throws RemoteException {
        ConfirmacaoMembroJogo confirmeMembroJogo = serviceBasic.getConfirmeMembroJogo(token);
        if (confirmeMembroJogo == null) {
            return false;
        }
        //
        Jogo jogo = confirmeMembroJogo.getJogo();
        Membro membro = confirmeMembroJogo.getMembro();
        if (!serviceBasic.findMembrosJogo(jogo.getId()).contains(membro)) {
            serviceBasic.addMembroAoJogo(jogo.getId(), membro.getId());
            serviceBasic.removeConfirmacaoMembroJogo(confirmeMembroJogo);
        } else {
            serviceBasic.removeConfirmacaoMembroJogo(confirmeMembroJogo);
        }
        //
        return true;
    }
    
    @Override
    public Album getAlbumJogo(Long idJogo) throws RemoteException {
        Jogo jogo = serviceBasic.findJogo(idJogo);
        return serviceBasic.getAlbum(jogo.getAlbum().getId());
    }


    @Override
    public Byte[] getImagemDado(Long idImagem) throws RemoteException {
        return serviceBasic.getImagemDado(idImagem);
    }

    @Override
    public Album getAlbum(Long idAlbum) throws RemoteException {
        return serviceBasic.getAlbum(idAlbum);
    }
    
    @Override
    public void modificarNomeAlbum(Long idAlbum,String nome) throws RemoteException{
        Album album=serviceBasic.getAlbum(idAlbum);
        album.setNome(nome);
        serviceBasic.editAlbum(album);
    }

    @Override
    public void addNovaImagemAlbum(Long idAlbum, Imagem imagem) throws RemoteException {
       serviceBasic.addNovaImagemAlbum(idAlbum, imagem);
    }

    @Override
    public List<Jogo> listJogoEstado(Integer numPagina, JogoEstado estado) throws RemoteException {
        return serviceBasic.finJogoPaginadoEstado(numPagina, estado);
    }

}
