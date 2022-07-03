package com.iudigital.supermercadohilos.supermercado.hilos.sinhilo;

import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.ClienteProducto;
import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.Producto;
import java.util.ArrayList;
import java.util.List;

public class MainSinHilos {

    public static void main(String[] args) {
        
    
    List<Producto> productos = new ArrayList<>();
    setProductos(productos);//
    
    
    //Constructor del cliente que recibe dos parámetros
    ClienteProducto cliente1 = new ClienteProducto ("Cliente 1", productos);
    ClienteProducto cliente2 = new ClienteProducto ("Cliente 2", productos);
    
    //constructor de cajera que recibe nombre de la cajera
    long intialTime = System.currentTimeMillis();
    CajeraProducto cajera1 = new CajeraProducto("Cajera 1");
    CajeraProducto cajera2 = new CajeraProducto("Cajera 2");
    
    //llamamos al metodo de procesar y le pasamos el cliente y el tiempo inicial
    
    cajera1.procesarCompra(cliente1, intialTime);
    cajera2.procesarCompra(cliente2, intialTime);
    
    }
    
    //metodo para ingresar los productos
    private static void setProductos(List<Producto> productos) {
        Producto producto1 = new Producto("Arroz", 23, 2);
        Producto producto2 = new Producto("Azucar", 50, 5);
        Producto producto3 = new Producto ("Cafe", 30, 1);
        
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
    }
}
