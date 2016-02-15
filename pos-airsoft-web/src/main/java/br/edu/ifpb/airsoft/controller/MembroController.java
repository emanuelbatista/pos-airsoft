/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.airsoft.controller;

import br.edu.ifpb.pos.entity.Membro;
import br.edu.ifpb.pos.service.ServiceDominio;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author emanuel
 */
@Controller
public class MembroController {

    @Autowired
    private ServiceDominio serviceDominio;

    @RequestMapping(value = "/membro/add", method = RequestMethod.GET)
    public String addMembro() {
        return "membro/addMembro";
    }

    @RequestMapping(value = "/membro/add", method = RequestMethod.POST)
    public String addMembro(@Valid Membro membro, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("erros", result.getAllErrors());
            return "membro/addMembro";
        }
        //
        try {
            serviceDominio.addMembro(membro);
        } catch (RemoteException ex) {
            Logger.getLogger(MembroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/membros";
    }

    @RequestMapping(value = "/membros")
    public String listMembros(Model model) {
        try {
            List<Membro> membros = serviceDominio.listAllMembro();
            model.addAttribute("membros", membros);
        } catch (RemoteException ex) {
            Logger.getLogger(MembroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "membro/listMembros";
    }
}
