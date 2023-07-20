/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChainOfResponsibility;

import Iterator.Producto;

/**
 *
 * @author alexc
 */
public class AsistenteAtencionUsuario implements Responsable{
    private Responsable next;

    @Override
    public void setNext(Responsable next) {
        this.next= next;
    }

    @Override
    public void procesarSolicitud(Solicitud solicitud) {
        if (solicitud.esSolicitudCambio()) {
            if (productoEnGarantia(solicitud.getProducto())) {
                next.procesarSolicitud(solicitud);
            } else {
                System.out.println("El producto no está en periodo de garantía.");
            }
        } else {
            System.out.println("La solicitud no es de cambio.");
        }
    }

    private boolean productoEnGarantia(Producto producto) {
        return true; 
    }
    
    
    
    
}
