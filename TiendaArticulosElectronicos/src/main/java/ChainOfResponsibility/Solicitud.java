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
public class Solicitud {
    private Producto producto;
    private String fallo;
    private double precio;
    private boolean esSolicitudCambio;

    public Solicitud(Producto producto, String fallo, double precio, boolean esSolicitudCambio) {
        this.producto = producto;
        this.fallo = fallo;
        this.precio = precio;
        this.esSolicitudCambio = esSolicitudCambio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getFallo() {
        return fallo;
    }

    public void setFallo(String fallo) {
        this.fallo = fallo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEsSolicitudCambio() {
        return esSolicitudCambio;
    }

    public void setEsSolicitudCambio(boolean esSolicitudCambio) {
        this.esSolicitudCambio = esSolicitudCambio;
    }

    
    public boolean esSolicitudCambio() {
        return esSolicitudCambio;
    }
}
