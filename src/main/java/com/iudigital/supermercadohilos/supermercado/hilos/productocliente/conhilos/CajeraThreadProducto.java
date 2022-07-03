package com.iudigital.supermercadohilos.supermercado.hilos.productocliente.conhilos;

import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.ClienteProducto;
import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.Producto;

public class CajeraThreadProducto extends Thread {

    private String nombre;
    private ClienteProducto cliente;
    private long initialTime;

    public CajeraThreadProducto(String nombre, ClienteProducto cliente, long intialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = intialTime;
    }
    
    @Override
    public void run() {
        System.out.println("La cajera" + this.nombre + "comienza a procesar la compra del cliente"
        + this.cliente.getNombre() + "en el tiempo: "
        + (System.currentTimeMillis() - this.initialTime)/1000
        + "segundos");
        
        int contCliente = 1;
        for(Producto producto : cliente.getProductos()) {
            this.esperarXsegundos();
            System.out.println("Procesado el producto " + contCliente
            + " precio producto " + producto.getPrecio()
            + " cantidad de productos " + producto.getCantidad()
            + " costo total del producto " + producto.getCantidad() * producto.getPrecio()
            + " del cliente " + this.cliente.getNombre() + "->Tiempo: "
            + (System.currentTimeMillis() - this.initialTime) / 1000
            + "seg");
            contCliente++;
        }
    }
        
    private void esperarXsegundos() {
        try {
            Thread.sleep(1000); //esperar un segundo
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }    
}
