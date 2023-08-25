package com.stagiaireapp.service.Classes;

import com.stagiaireapp.Model.Stage;
import com.stagiaireapp.Repository.StageRepository;
import com.stagiaireapp.service.Interfaces.IStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class Stagelmp implements IStage {
    @Autowired
    private StageRepository stageRepository;
    @Override
    public List<Stage> getAllStage(){ return stageRepository.findAll();}
    @Override
    public Stage saveStage(Stage stage) {
        return stageRepository.save(stage);
    }

    @Override
    public Stage getStageById(Long id) {
        return stageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
    }

    @Override
    public Stage updateStage(Long id, Stage stage) {
        Stage existingStage = stageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        // Update fields in existingStage

        return stageRepository.save(existingStage);
    }

    @Override
    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }
}
