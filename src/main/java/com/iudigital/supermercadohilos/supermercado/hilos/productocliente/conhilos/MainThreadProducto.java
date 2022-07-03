package com.iudigital.supermercadohilos.supermercado.hilos.productocliente.conhilos;

import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.ClienteProducto;
import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.Producto;
import com.iudigital.supermercadohilos.supermercado.hilos.productocliente.conhilos.CajeraThreadProducto;
import java.util.ArrayList;
import java.util.List;

public class MainThreadProducto {

    public static void main(String[] args) {
        
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);
        ClienteProducto cliente1 = new ClienteProducto("cliente1 ", productos );
        ClienteProducto cliente2 = new ClienteProducto("cliente2 ", productos);
        
        long initialTime = System.currentTimeMillis();
        CajeraThreadProducto cajera1 = new CajeraThreadProducto("cajera1 ", cliente1, initialTime);
        CajeraThreadProducto cajera2 = new CajeraThreadProducto("cajera2 ", cliente2, initialTime);
        
        cajera1.start();
        cajera2.start();
    }
    
    private static void setProductos(List<Producto> productos){
        
        Producto producto1 = new Producto("arroz", 23, 2);
        Producto producto2 = new Producto("azucar", 50, 5);
        Producto producto3 = new Producto("cafe", 30, 1);
        
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
    }
}
