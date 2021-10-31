/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto4y5_Doctor.Reto4y5_Doctor;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface InterfaceReservaciones extends CrudRepository<ModeloReservaciones,Integer>{
    public List<ModeloReservaciones> findAllByStatus (String status);
    
    public List<ModeloReservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from ModeloReservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByCliente();
    
}
