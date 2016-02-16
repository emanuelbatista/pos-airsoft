/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.dominio.service.email;

import br.edu.ifpb.pos.entity.Jogo;
import br.edu.ifpb.pos.entity.Membro;
import br.edu.ifpb.pos.service.dominio.util.GenerateCodeUtils;
import java.util.List;

/**
 *
 * @author emanuel
 */
public class Mail {

    private final String EMAIL = "airsoftplaygames@gmail.com";

    public String enviarConfirmacaoMembroJogo(Jogo jogo, Membro membro) {
        String codigo = GenerateCodeUtils.generateCode("", 40, membro.getEmail() + System.currentTimeMillis());
        String message = montarMessageConfirmacaoJogo(membro, jogo, codigo);
        SendMail sendMail = new SendMail();
        new Thread(() -> {
            sendMail.sendMail(EMAIL, membro.getEmail(), "CONFIRMAÇÃO DE PARTICIPAÇÃO DE JOGO - AIRSOFT", message);
        }).start();
        return codigo;
    }

    private String montarMessageConfirmacaoJogo(Membro membro, Jogo jogo, String codigo) {
        StringBuilder message = new StringBuilder();
        message.append("Confirme sua paticipação no jogo do Airsoft <br>");
        message.append("Para efetuar a confirmação adicione o token ao campo que está contido na página do link <br><br>");
        message.append("<b>TOKEN:</b> ").append(codigo).append("<br>");
        message.append("<b>LINK PARA CONFIRMAÇÃO:</b> ").append("<a href=\"http://localhost:8080/jogo/membro/confirmacao/").append(jogo.getId()).
                append("\">http://localhost:8080/jogo/membro/confirmacao/").append(jogo.getId()).append("</a>");
        return message.toString();
    }

    public void enviarMudancaEstadoJogo(Jogo jogo, List<Membro> membros) {
        SendMail sendMail = new SendMail();
        String message=messageMudancaEstadoJogo(jogo);
        for (Membro membro : membros) {
            new Thread(() -> {
                sendMail.sendMail(EMAIL, membro.getEmail(), "MUDANÇA DO ESTADO DO JOGO - AIRSOFT", message);
            }).start();
        }
    }

    private String messageMudancaEstadoJogo(Jogo jogo) {
        StringBuilder message=new StringBuilder();
        String link="http://localhost:8080/jogo/"+jogo.getId();
        message.append("Houve uma mudanaça no estado no jogo que você é Membro<br>");
        message.append("Verifique a mudança no estado no link abaixo.<br>");
        message.append("<b>Estado do Jogo:</b> ").append(jogo.getEstado().toString().toUpperCase()).append("<br>");
        message.append("Link do jogo: ").append("<a href=\"").append(link).append("\">")
                .append(link).append("</a>");
        return message.toString();
    }

}
