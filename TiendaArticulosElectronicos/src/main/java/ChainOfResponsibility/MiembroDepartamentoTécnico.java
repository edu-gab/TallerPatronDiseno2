/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChainOfResponsibility;

/**
 *
 * @author alexc
 */
public class MiembroDepartamentoTécnico implements Responsable{
     private Responsable next;

    @Override
    public void setNext(Responsable next) {
        this.next = next;
    }

    @Override
    public void procesarSolicitud(Solicitud solicitud) {
        if (solicitud.esSolicitudCambio()) {
            if (falloCubiertoPorGarantia(solicitud.getFallo())) {
                next.procesarSolicitud(solicitud);
            } else {
                System.out.println("El fallo no está cubierto por la garantía.");
            }
        } else {
            System.out.println("La solicitud no es de cambio.");
        }
    }

    private boolean falloCubiertoPorGarantia(String fallo) {
        return true; 
    }
    
}
