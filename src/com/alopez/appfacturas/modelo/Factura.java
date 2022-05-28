package com.alopez.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;

    public static final int MAX_ITEMS = 10; //Creamos una constante para el máximo de items
    private static int ultimoFolio; //Para incrementar el folio, necesitamos esta variable





    private Cliente cliente; //Una factura está asociada a un cliente
    private ItemFactura[] items; //Es un arreglo porque puede tener varios items
    private int indiceItems; //Se requiere de este indice, para poder ir agregando con el metodo add


    public Factura(String descripcion, Cliente cliente) { //Creamos el constructor para descripcion y cliente
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];//Agregamos la instancia de items
        this.folio = ++ultimoFolio; //Agregamos este this, con un preincremento a ultimoFolio, con eso, empezamos en 1
        //Con este ultimo, se evita tener un setFolio, ya que se autogenera
        this.fecha = new Date(); //Cuando se crea la factura, también se genera con la fecha
    }




    //Método Getter and Setter de folio, descripcion y fecha
    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    //Getter and Setter de Cliente
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Gettter de itemFactura
    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item){ //Metodo add, recibe un solo elemento item
        if(indiceItems < MAX_ITEMS) { //Verifica que el indice de items no supere el maximo tamaño del arreglo
            this.items[indiceItems++] = item; //indiceItems incrementa con un post-incremento
        }
    }

    public float calcularTotal(){ //Metodo para calcular el total de la factura
        float total = 0.0f; //iniciamos una variable local float
        for (ItemFactura item: this.items) { //For each
            if (item == null) { //Si item es igual a null entonces continuamos a la siguiente iteracion
                //Otra alternativa a es if es la siguiente if( ! (item.instanceof ItemFactura))
                continue;
            }
            total += item.calcularImporte(); //Por cada item se calcula el importe
        }
        return total;
    }

    public String generarDetalle(){ //Generamos el detalle de la factura
        StringBuilder sb = new StringBuilder("Factura # "); //Concatenamos con StringBuilder ya que son muchos datos
        sb.append(folio).append("\nCliente # ").append(this.cliente.getNombre()) //Se utiliza .append para concatenacion
                .append("\t Identificación Tributaria # ").append(cliente.getIdentificacionTributaria())
                .append("\nDescripción: ").append(this.descripcion).append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy"); //Damos formato a la fecha
        sb.append("Fecha Emisión: ").append(df.format(this.fecha)).append("\n")
                .append("\n#\tNombre\t \tPrecio: \tCantidad\tTotal\n");

        for (ItemFactura item: this.items) { //Por cada línea
            if(item ==null) //Si item es igual a null entonces continuamos a la siguiente iteracion
                continue;
            sb.append(item.getProducto().getCodigo()).append("\t") //Concatenamos el codigo del producto
                    .append(item.getProducto().getNombre()).append("\t \t") //Concatenamos el nombre del producto
                    .append(item.getProducto().getPrecio()).append("\t \t") //Concatenamos el precio del producto
                    .append(item.getCantidad()).append("\t \t") //Concatenamos la cantidad del producto
                    .append(item.calcularImporte()).append("\n"); //Concatenamos el calculo del importe del producto
        }
        sb.append("\nTotal Final: ").append(calcularTotal()); //Calculamos el total de la factura
        return sb.toString();
    }

}
