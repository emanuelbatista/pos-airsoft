/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.service.dominio;

import br.edu.ifpb.pos.service.dominio.service.ServiceDominioImp;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

/**
 *
 * @author emanuel
 */
public class Main {
    public static void main(String[] args) {
        try {
            Endpoint.publish("http://localhost:8003", new ServiceDominioImp());
        } catch (RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
