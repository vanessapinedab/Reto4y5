/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4y5_Doctor.Reto4y5_Doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServiciosReservaciones {
    
     @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<ModeloReservaciones> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<ModeloReservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public ModeloReservaciones save(ModeloReservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<ModeloReservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public ModeloReservaciones update(ModeloReservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<ModeloReservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //este es el mio
    public StatusReservas reporteStatusServicio(){
        List<ModeloReservaciones>completed=metodosCrud.ReservacionStatusRepositorio("completed");
        List<ModeloReservaciones>cancelled=metodosCrud.ReservacionStatusRepositorio("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<ModeloReservaciones> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try{
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);

        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        }   
    }
/**
* M??todo para reporte de clientes
*/
    public List<ContadorClientes> reporteClientesServicio() {
        return metodosCrud.getClientesRepositorio();
    }
    
    
}
