/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.airsoft.jogo;

import br.edu.ifpb.pos.entity.Jogo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author emanuel
 */
@Controller
public class JogoController {
    
    @RequestMapping(value = "/jogos",method = RequestMethod.GET)
    public String listJogos(){
        return "jogo/listJogo";
    }
    
    @RequestMapping(value = "/jogo/add",method = RequestMethod.GET)
    public String addJogo(Jogo jogo){
        return "jogo/addJogo";
    }
}
