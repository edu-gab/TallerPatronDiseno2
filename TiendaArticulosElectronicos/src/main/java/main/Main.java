/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import ChainOfResponsibility.AsistenteAtencionUsuario;
import ChainOfResponsibility.JefeInventario;
import ChainOfResponsibility.MiembroDepartamentoTécnico;
import ChainOfResponsibility.Responsable;
import ChainOfResponsibility.Solicitud;
import Iterator.BodegaNacional;
import Iterator.Producto;
import Iterator.Iterator;
import Strategy.Area;
import Strategy.Automotriz;
import Strategy.Ciclista;
import Strategy.Distribucion;
import Strategy.Ferrea;
import Strategy.Fluvial;
import Strategy.Transporte;
import java.util.Scanner;

/**
 *
 * @author joelorrala
 */
public class Main {

    public static void main(String[] args) {
        BodegaNacional inventario = new BodegaNacional();
        
        Scanner sc = new Scanner(System.in);

        inventario.agregarProducto(new Producto("Iphone 14", "celular", 120));
        inventario.agregarProducto(new Producto("Riviera", "televisión", 50));
        inventario.agregarProducto(new Producto("Samsung Tab S8", "tablet", 30));
        inventario.agregarProducto(new Producto("Epson", "impresora", 100));
        inventario.agregarProducto(new Producto("Canon", "cámara", 70));
        inventario.agregarProducto(new Producto("Lenovo Legion", "laptop", 80));
        inventario.agregarProducto(new Producto("LG", "televisión", 90));
        inventario.agregarProducto(new Producto("Huawei y5", "celular", 5));
        
        Producto prueba = new Producto("HP", "laptop", 50);
        

        System.out.println("----- Comprador Web navegando -----");
        Iterator compradorIterator = inventario.crearIterador();
        while (compradorIterator.hasNext()) {
            Producto producto = compradorIterator.next();
            System.out.println(producto.getNombre() + " - " + producto.getCategoria());
        }

        System.out.println("\n----- Vendedor verificando disponibilidad de televisores -----");
        Iterator vendedorIterator = inventario.crearIterador();
        while (vendedorIterator.hasNext()) {
            Producto producto = vendedorIterator.next();
            if (producto.getCategoria().equals("televisión")) {
                System.out.println(producto.getNombre());
            }
        }
        
        System.out.println("\n------ Proveedor observando los productos con falla -----");
        Iterator proveedorIterator = inventario.crearIterador();
        while (proveedorIterator.hasNext()) {
            Producto producto = proveedorIterator.next();
            if (producto.getCantidad() < 10) {
                System.out.println(producto.getNombre());
            }
        }
        
        
        Responsable asistente = new AsistenteAtencionUsuario();
        Responsable tecnico = new MiembroDepartamentoTécnico();
        Responsable jefeInventario = new JefeInventario();

        asistente.setNext(tecnico);
        tecnico.setNext(jefeInventario);
        Solicitud solicitud = new Solicitud(new Producto("Iphone 14", "celular", 120),"true",252.2,false);
        asistente.procesarSolicitud(solicitud);
        
        System.out.println("\nSeleccione el vehiculo para llevar el articulo: ");
        System.out.println("\n1. Carro"
                + "\n2. Bicicleta"
                + "\n3. Tren"
                + "\n4. Avion"
                + "\n5. Fluvial");

        int opcion = 0;
        System.out.print("Opcion:");
        opcion = sc.nextInt();
        
        
        switch(opcion){
            case 1:
                Distribucion transporte = new Distribucion(new Automotriz());
                System.out.println(transporte.realizarDistribucion(prueba));
                break;
            case 2:
                transporte = new Distribucion(new Ciclista());
                System.out.println(transporte.realizarDistribucion(prueba));
                break;
            case 3:
                transporte = new Distribucion(new Ferrea());
                System.out.println(transporte.realizarDistribucion(prueba));
                break;
            case 4:
                transporte = new Distribucion(new Area());
                System.out.println(transporte.realizarDistribucion(prueba));
                break;
            case 5:
                transporte = new Distribucion(new Fluvial());
                System.out.println(transporte.realizarDistribucion(prueba));
                break;
                
        }
        
        
        
        
    }
}
