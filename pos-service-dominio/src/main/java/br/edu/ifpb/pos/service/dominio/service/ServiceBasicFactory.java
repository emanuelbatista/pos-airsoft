/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.dominio.service;

import br.edu.ifpb.pos.service.ServiceBasic;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Fábrica para que retorna o serviço básico da aplicação
 *
 * @author emanuel
 */
public class ServiceBasicFactory {

    /**
     * Instância a classe responsável pelos serviços básico (infraestrutura) da aplicação 
     * 
     * @return Servi ço Básico (Infraestrutura)
     * @throws MalformedURLException 
     */
    public static ServiceBasic getInstance() throws MalformedURLException {
        URL url = new URL("http://localhost:8000/airsoft?wsdl");
        QName qName = new QName("http://service.pos.ifpb.edu.br/", "ServiceBasic");
        Service service = Service.create(url, qName);
        return service.getPort(ServiceBasic.class);

    }
}
