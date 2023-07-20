/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChainOfResponsibility;

/**
 *
 * @author alexc
 */
public class Gerente implements Responsable{
    private Responsable next;

    @Override
    public void setNext(Responsable next) {
        this.next = next;
    }

    @Override
    public void procesarSolicitud(Solicitud solicitud) {
        if (solicitud.esSolicitudCambio()) {
            // Verificar si el precio de venta del producto es mayor a $1000
            if (solicitud.getPrecio() > 1000) {
                System.out.println("Solicitud de cambio aprobada por el gerente.");
            } else {
                next.procesarSolicitud(solicitud);
            }
        } else {
            System.out.println("La solicitud no es de cambio.");
        }
    }
}
