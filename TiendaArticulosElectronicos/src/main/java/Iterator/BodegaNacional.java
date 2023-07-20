/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelorrala
 */
public class BodegaNacional implements Inventario {
    private List<Producto> productos;

    public BodegaNacional() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Iterator crearIterador() {
        return new InventarioIterator(productos);
    }

}
