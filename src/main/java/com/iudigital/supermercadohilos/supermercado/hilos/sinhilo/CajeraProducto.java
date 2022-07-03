package com.iudigital.supermercadohilos.supermercado.hilos.sinhilo;

import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.ClienteProducto;
import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.Producto;

public class CajeraProducto {

    private String nombre;
    
    public CajeraProducto (String nombre) {
        this.nombre = nombre;
    }
    
    public void procesarCompra (ClienteProducto cliente, long timeStamp) {
        System.out.println("La cajera " + this.nombre + 
                "comienza a procesar la compra del cliente " + cliente.getNombre()
        + "en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000
        + "segundos");
        
        int contCliente = 1;
        for(Producto producto : cliente.getProductos()) {
            this.esperarXsegundos();
            System.out.println("Procesando el producto" + contCliente
            + "nombre producto " + producto.getNombre()
            + "precio producto " + producto.getPrecio()
            + "cantidad de productos " + producto.getCantidad()
            + "Costo total del product " + producto.getCantidad() * producto.getPrecio()
            + "->Tiempo: " + (System.currentTimeMillis() - timeStamp)/ 1000
            + "segundos");
        }
    }
    
    private void esperarXsegundos() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
