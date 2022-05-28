package com.alopez.appfacturas.modelo;

public class ItemFactura {

    private int cantidad;
    private Producto producto; //Relacion que tiene con el producto


    public ItemFactura(int cantidad, Producto producto) { //Constructor para inicializar cantidad y producto
        this.cantidad = cantidad;
        this.producto = producto;
    }

    //Metodos Getter and Setter de cantidad
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //Calculamos el total del importe, precio producto * cantidad
    public float calcularImporte(){
        return this.cantidad * this.producto.getPrecio();
    }

}