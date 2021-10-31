/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4y5_Doctor.Reto4y5_Doctor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ServiciosEspecialidad {
    
    @Autowired
    private RepositorioEspecialidad metodosCrud;
    
    public List<ModeloEspecialidad> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<ModeloEspecialidad> getSpecialty(int idSpecialty){
        return metodosCrud.getSpecialty(idSpecialty);
    }
    
    public ModeloEspecialidad save(ModeloEspecialidad specialty){
        if(specialty.getId()==null){
            return metodosCrud.save(specialty);
        }else{
            Optional<ModeloEspecialidad> e= metodosCrud.getSpecialty(specialty.getId());
            if(e.isEmpty()){
                return metodosCrud.save(specialty);
            }else{
                return specialty;
            }
        }
    }   

    public ModeloEspecialidad update(ModeloEspecialidad specialty){
        if(specialty.getId()!=null){
            Optional<ModeloEspecialidad>g=metodosCrud.getSpecialty(specialty.getId());
            if(!g.isEmpty()){
                if(specialty.getDescription()!=null){
                    g.get().setDescription(specialty.getDescription());
                }
                if(specialty.getName()!=null){
                    g.get().setName(specialty.getName());
                }
                return metodosCrud.save(g.get());
            }
        }
        return specialty;
    }
    public boolean deletespecialty(int specialtyId){
        Boolean d=getSpecialty(specialtyId).map(specialty -> {
            metodosCrud.delete(specialty);
            return true;
        }).orElse(false);
        return d;
    }
    
}
