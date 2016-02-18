/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.basic;

import br.edu.ifpb.pos.service.basic.service.ServiceBasicImp;
import javax.xml.ws.Endpoint;

/**
 * 
 * @author emanuel
 */
public class Main {
    
    /**
     * Disponibiliza os serviços básico (infraestrutura) da aplicação para uso via SOAP - Document
     * @param args 
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8000/airsoft", new ServiceBasicImp());
    }
    
}
