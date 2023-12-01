package com.api.controller;

import com.api.model.Participante;
import com.api.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<Participante> listarTodos() {
        return participanteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Participante> obtenerPorId(@PathVariable Long id) {
        Optional<Participante> participante = participanteService.obtenerPorId(id);
        return participante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Participante guardar(@RequestBody Participante participante) {
        return participanteService.guardar(participante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participante> actualizar(@PathVariable Long id, @RequestBody Participante participante) {
        return participanteService.obtenerPorId(id)
            .map(participanteExistente -> {
                participanteExistente.setNombre(participante.getNombre());
                participanteExistente.setEdad(participante.getEdad());
                participanteExistente.setTalla(participante.getTalla());
                participanteExistente.setSede(participante.getSede());
                participanteExistente.setPuntoDeSalida(participante.getPuntoDeSalida());
                Participante actualizado = participanteService.guardar(participanteExistente);
                return ResponseEntity.ok(actualizado);
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (participanteService.obtenerPorId(id).isPresent()) {
            participanteService.eliminar(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
