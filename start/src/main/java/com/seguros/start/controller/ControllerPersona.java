package com.seguros.start.controller;
import com.seguros.start.message.Message;
import com.seguros.start.dto.Personas;
import com.seguros.start.facade.PersonaFd;
import com.seguros.start.facade.PersonaFDImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ControllerPersona {
    private PersonaFd personaFd = PersonaFDImp.getPersonaFD();
    @PostMapping("/personas/insertarPersonas")
    public ResponseEntity<Message> insertarPersonas(@RequestBody Personas personas){
        Message message = new Message("1", "se creó con éxito","");
        try{
            personaFd.create(personas);
            message.setData(personas);
        }catch (Exception e){
            message.setId("404");
            message.setMessage("No se pudo crear con éxito");

        }
        return ResponseEntity.ok(message);
    }
    /*@GetMapping("/personas/selectAll")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1", "mostrado con éxito","");
        ArrayList<Personas> listaPerson = null;
        try{
            listaPerson = personaFd.selectAll();
            message.setData(listaPerson);
        }catch (Exception e){
            message.setId("404");
            message.setMessage(e.getMessage());

        }
        return ResponseEntity.ok(message);
    }
    @PostMapping("/person/delete")
    public ResponseEntity<Message> delete(@RequestBody Personas personas) {
        Message message = new Message("1", "Eliminado con exito", "");
        personas.setIdPersona(3);
        try {
            personaFd.delete(personas);
            message.setData(personas);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }*/


}
