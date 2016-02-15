/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.airsoft.controller;

import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.Membro;
import br.edu.ifpb.pos.service.ServiceDominio;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author emanuel
 */
@Controller
public class JogoController {

    @Autowired
    private ServiceDominio serviceDominio;

    @RequestMapping(value = {"/jogos", "/jogos/{numPage}"}, method = RequestMethod.GET)
    public String listJogos(@PathVariable Integer numPage, Model model) {
        try {
            if (numPage.equals(0)) {
                numPage = 1;
            }
            model.addAttribute("numPage", numPage);
            model.addAttribute("listJogo", serviceDominio.listJogos(numPage));
        } catch (RemoteException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "jogo/listJogo";
    }

    @RequestMapping(value = "/jogo/{idJogo}")
    public String getJogo(@PathVariable Long idJogo, Model model) {
        try {
            Jogo jogo = serviceDominio.getJogo(idJogo);
            model.addAttribute("jogo", jogo);
        } catch (RemoteException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "jogo/jogo";
    }

    @RequestMapping(value = "/jogo/add", method = RequestMethod.GET)
    public String addJogo() {
        return "jogo/addJogo";
    }

    @RequestMapping(value = "/jogo/add", method = RequestMethod.POST)
    public String addJogo(@Valid Jogo jogo, BindingResult result, Model model, @RequestParam MultipartFile image) {
        if (result.hasErrors()) {
            model.addAttribute("erros", result.getAllErrors());
            return "jogo/addJogo";
        }
        try {
            jogo.setFoto(image.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        LocalDateTime localDateTime = LocalDateTime.parse(jogo.getHorario());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        jogo.setHorario(localDateTime.format(dateTimeFormatter));
        try {
            serviceDominio.addJogo(jogo);
        } catch (RemoteException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/jogos";
    }

    @RequestMapping("/jogo/image/{idJogo}")
    public void getImageJogo(OutputStream out, @PathVariable Long idJogo) {
        try {
            Jogo jogo = serviceDominio.getJogo(idJogo);
            out.write(jogo.getFoto());
            out.flush();
        } catch (RemoteException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @RequestMapping(value = "/jogo/nao/membro/pesquisa", method = RequestMethod.GET)
    public @ResponseBody
    List<Object[]> pesquisarMembrosNaoCorrespondente(@RequestParam("id") Long idJogo, @RequestParam String pesquisa) {
        List<Membro> membros = null;
        try {
            membros = serviceDominio.listMembrosJogoNaoCorrespondente(idJogo, pesquisa);
        } catch (RemoteException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Object[]> objects = new ArrayList<>();
        membros.forEach(x -> {
            Object[] object = new Object[3];
            object[0] = x.getId();
            object[1] = x.getNome();
            object[2] = x.getEmail();
            objects.add(object);
        });
        return objects;
    }

    @RequestMapping(value = "/jogo/{idJogo}/membros")
    public String getMembrosJogo(@PathVariable Long idJogo, Model model) {
        try {
            List<Membro> membros= serviceDominio.listMembroJogo(idJogo);
            model.addAttribute("idJogo", idJogo);
            model.addAttribute("membros", membros);
        } catch (RemoteException ex) {
            Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "jogo/membros";
    }

    @RequestMapping(value = "/jogo/membros/add", method = RequestMethod.POST)
    public String addMembroJogo(@RequestParam Long idJogo, @RequestParam List<Long> idMembro) {
        for (Long idMembro1 : idMembro) {
            try {
                serviceDominio.addMembroAoJogo(idJogo, idMembro1);
            } catch (RemoteException ex) {
                Logger.getLogger(JogoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "redirect:/jogo/"+idJogo+"/membros";
    }
}
