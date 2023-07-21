/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

import Iterator.Producto;

/**
 *
 * @author edu-g
 */
public class Distribucion {
    
    private Transporte transporte;
    
    public Distribucion(Transporte transporte){
        this.transporte = transporte;
    }
    
    public String realizarDistribucion(Producto producto){
        
        return transporte.distribuir(producto);
    }
}

