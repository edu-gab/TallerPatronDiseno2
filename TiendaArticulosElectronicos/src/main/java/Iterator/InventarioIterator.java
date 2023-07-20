/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;

import java.util.List;

/**
 *
 * @author joelorrala
 */
public class InventarioIterator implements Iterator {
    private List<Producto> productos;
    private int posicionActual;

    public InventarioIterator(List<Producto> productos) {
        this.productos = productos;
        this.posicionActual = 0;
    }

    @Override
    public boolean hasNext() {
        return posicionActual < productos.size();
    }

    @Override
    public Producto next() {
        if (hasNext()) {
            Producto producto = productos.get(posicionActual);
            posicionActual++;
            return producto;
        }
        return null;
    }
}
