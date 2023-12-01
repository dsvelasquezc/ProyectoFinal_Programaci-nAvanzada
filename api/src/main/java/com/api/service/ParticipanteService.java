package com.api.service;

import com.api.model.Participante;
import com.api.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    public List<Participante> listarTodos() {
        return participanteRepository.findAll();
    }

    public Optional<Participante> obtenerPorId(Long id) {
        return participanteRepository.findById(id);
    }

    public Participante guardar(Participante participante) {
        return participanteRepository.save(participante);
    }

    public void eliminar(Long id) {
        participanteRepository.deleteById(id);
    }
}

