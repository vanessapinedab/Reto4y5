/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4y5_Doctor.Reto4y5_Doctor;

/**
 *
 * @author Usuario
 */
public class ContadorClientes {
    
    private Long total;
    private ModeloCliente client;

    public ContadorClientes(Long total, ModeloCliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public ModeloCliente getClient() {
        return client;
    }

    public void setClient(ModeloCliente client) {
        this.client = client;
    }
    
    
    
}
