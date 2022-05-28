package com.alopez.appfacturas;

import com.alopez.appfacturas.modelo.Cliente;
import com.alopez.appfacturas.modelo.Factura;
import com.alopez.appfacturas.modelo.ItemFactura;
import com.alopez.appfacturas.modelo.Producto;

import java.util.Scanner;

public class EjemploFactura {

    public static void main(String[] args) { //Creamos metodo main

        Cliente cliente = new Cliente(); //Creamos un Objeto cliente, importamos de la clase cliente
        cliente.setIdentificacionTributaria("5555-5"); //Asignamos la Id Tributaria
        cliente.setNombre("Alejandro"); //Asignamos el nombre del cliente

        Scanner scanner = new Scanner(System.in); //Creamos clase scanner para obtener datos por consola
        System.out.println("Ingrese una descripcion de la factura");
        String desrip = scanner.nextLine(); //Guardamos el texto ingresado
        Factura factura = new Factura(desrip, cliente); //Creamos un Objeto Factura, importamos de la clase factura
        //recibe por argumento el string ingresado con scanner y el cliente que creamos

        Producto producto; //Creamos un producto
        String nombre; //Asignamos un nombre al producto
        float precio; //Asignamos un precio al producto
        int cantidad; //Asignamos la cantidad de productos

        System.out.println();

        for (int i = 0; i<5; i++){ //For hasta 5 para registrar 5 productos
            producto = new Producto();
            System.out.print("Ingrese producto # " + producto.getCodigo() + ": ");
            nombre = scanner.nextLine(); //next permite registrar texto sin espacios
            producto.setNombre(nombre); //Asignamos el nombre con setNombre

            System.out.print("Ingrese el precio: ");
            precio = scanner.nextFloat(); //nextFloat captura un numero con decimales
            producto.setPrecio(precio); //Asignamos el precio con setPrecio

            System.out.print("Ingrese la cantidad: ");
            cantidad = scanner.nextInt(); //Permite capturar un numero entero

            ItemFactura item = new ItemFactura(cantidad, producto); //ItemFactura nos pide la cantidad y el proucto
            factura.addItemFactura(item); //Agregamos el item con add

            System.out.println();
            scanner.nextLine();
        }

        System.out.println(factura.generarDetalle()); //Imprimimos los detalles de la factura


    }

}