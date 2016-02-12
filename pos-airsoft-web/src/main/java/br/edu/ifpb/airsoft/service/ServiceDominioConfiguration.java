/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.airsoft.service;

import br.edu.ifpb.pos.service.ServiceDominio;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author emanuel
 */
@Configuration
public class ServiceDominioConfiguration {
    
//    @Bean
    public ServiceDominio getService(){
        try {
            URL url=new URL("http://localhost:8003/service");
            QName qName=new QName("ServiceDominio");
            Service service=Service.create(url, qName);
            return service.getPort(ServiceDominio.class);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceDominioConfiguration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}