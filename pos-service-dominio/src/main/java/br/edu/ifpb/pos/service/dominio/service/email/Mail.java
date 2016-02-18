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
 * Responsável por montar a messagem de e-mail e enviar para o destino
 *
 * @author emanuel
 */
public class Mail {

    private final String EMAIL = "airsoftplaygames@gmail.com";

    /**
     * Monta e enviar uma mensagem de email para confirmação do membro ao jogo
     * @param jogo
     * @param membro
     * @return Token de Confirmação
     */
    public String enviarConfirmacaoMembroJogo(Jogo jogo, Membro membro) {
        String codigo = GenerateCodeUtils.generateCode("", 40, membro.getEmail() + System.currentTimeMillis());
        String message = montarMessageConfirmacaoJogo(membro, jogo, codigo);
        SendMail sendMail = new SendMail();
        new Thread(() -> {
            sendMail.sendMail(EMAIL, membro.getEmail(), "CONFIRMAÇÃO DE PARTICIPAÇÃO DE JOGO - AIRSOFT", message);
        }).start();
        return codigo;
    }

    /**
     * Monta a messagem de e-mail de confirmação do membro ao joogo
     * @param membro
     * @param jogo
     * @param codigo
     * @return Messagem de e-amil
     */
    private String montarMessageConfirmacaoJogo(Membro membro, Jogo jogo, String codigo) {
        StringBuilder message = new StringBuilder();
        message.append("Confirme sua paticipação no jogo do Airsoft <br>");
        message.append("Para efetuar a confirmação adicione o token ao campo que está contido na página do link <br><br>");
        message.append("<b>TOKEN:</b> ").append(codigo).append("<br>");
        message.append("<b>LINK PARA CONFIRMAÇÃO:</b> ").append("<a href=\"http://localhost:8080/jogo/membro/confirmacao/").append(jogo.getId()).
                append("\">http://localhost:8080/jogo/membro/confirmacao/").append(jogo.getId()).append("</a>");
        return message.toString();
    }

    /**
     * Monta e envia a messagem de e-amil para o membro que participa de um jogo, no qual teve seu estado alterado
     * @param jogo
     * @param membros 
     */
    public void enviarMudancaEstadoJogo(Jogo jogo, List<Membro> membros) {
        SendMail sendMail = new SendMail();
        String message = messageMudancaEstadoJogo(jogo);
        for (Membro membro : membros) {
            new Thread(() -> {
                sendMail.sendMail(EMAIL, membro.getEmail(), "MUDANÇA DO ESTADO DO JOGO - AIRSOFT", message);
            }).start();
        }
    }

    /**
     * Monta a messagem de mundança de estado de um jogo
     * @param jogo
     * @return Messagem de email
     */
    private String messageMudancaEstadoJogo(Jogo jogo) {
        StringBuilder message = new StringBuilder();
        String link = "http://localhost:8080/jogo/" + jogo.getId();
        message.append("Houve uma mudanaça no estado no jogo que você é Membro<br>");
        message.append("Verifique a mudança no estado no link abaixo.<br>");
        message.append("<b>Estado do Jogo:</b> ").append(jogo.getEstado().toString().toUpperCase()).append("<br>");
        message.append("Link do jogo: ").append("<a href=\"").append(link).append("\">")
                .append(link).append("</a>");
        return message.toString();
    }

}
