package ChainOfResponsibility;

import Iterator.Producto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alexc
 */
public class JefeInventario implements Responsable{
    private Responsable next;

    @Override
    public void setNext(Responsable next) {
        this.next = next;
    }

    @Override
    public void procesarSolicitud(Solicitud solicitud) {
        if (solicitud.esSolicitudCambio()) {
            // Verificar si el producto está en inventario
            if (productoEnInventario(solicitud.getProducto())) {
                if (solicitud.getPrecio() > 1000) {
                    Responsable gerente = new Gerente();
                    gerente.procesarSolicitud(solicitud);
                } else {
                    System.out.println("Solicitud de cambio aprobada por el jefe de inventario.");
                }
            } else {
                if (next != null) {
                    next.procesarSolicitud(solicitud);
                } else {
                    System.out.println("El producto no se encuentra en inventario para reposición.");
                }
            }
        } else {
            System.out.println("La solicitud no es de cambio.");
        }
    }

    private boolean productoEnInventario(Producto producto) {
        
        return true; 
    }
}
