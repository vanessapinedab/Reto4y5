/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4y5_Doctor.Reto4y5_Doctor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class RepositorioReservaciones {
    
    @Autowired
    private InterfaceReservaciones crud4;

    public List<ModeloReservaciones> getAll(){
        return (List<ModeloReservaciones>) crud4.findAll();
    }
    public Optional<ModeloReservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public ModeloReservaciones save(ModeloReservaciones reservation){
        return crud4.save(reservation);
    }   
    public void delete(ModeloReservaciones reservation){
        crud4.delete(reservation);
    }
    
    public List<ModeloReservaciones> ReservacionStatusRepositorio(String status){
        return crud4.findAllByStatus(status);
    }
    
    public List<ModeloReservaciones> ReservacionTiempoRepositorio (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     }
      
    
    public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByCliente();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(ModeloCliente) report.get(i)[0]));
         }
         return res;
     }
    
}
