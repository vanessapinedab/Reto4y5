/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4y5_Doctor.Reto4y5_Doctor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioCliente {
    
    @Autowired
    private InterfaceCliente crud;

    public List<ModeloCliente> getAll(){
        return (List<ModeloCliente>) crud.findAll();
    }
    public Optional<ModeloCliente> getCliente(int id){
        return crud.findById(id);
    }
    public ModeloCliente save(ModeloCliente client){
        return crud.save(client);
    }  
    public void delete(ModeloCliente client){
        crud.delete(client);
    }
    
}
