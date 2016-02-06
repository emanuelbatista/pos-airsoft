/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.dominio.service;

import br.edu.ifpb.pos.service.ServiceBasic;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author emanuel
 */
public class ServiceDominioImp {
    
    private ServiceBasic serviceBasic;

    public ServiceDominioImp() throws RemoteException {
        try {
            URL url = new URL("http://localhost:8000/airsoft?wsdl");
            QName qName = new QName("http://service.pos.ifpb.edu.br/", "ServiceBasic");
            Service service = Service.create(url, qName);
            this.serviceBasic = service.getPort(ServiceBasic.class);
        } catch (MalformedURLException ex) {
            throw new RemoteException(ex.getMessage());
        }
    }
    
    

}
