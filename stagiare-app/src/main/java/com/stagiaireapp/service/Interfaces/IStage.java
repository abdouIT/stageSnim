package com.stagiaireapp.service.Interfaces;

import com.stagiaireapp.Model.Stage;

import java.util.List;

public interface IStage {
    public List<Stage> getAllStage();
    public Stage saveStage(Stage stage);
    public Stage getStageById(Long id);
    public Stage updateStage(Long id, Stage stage);
    public void deleteStage(Long id);
}
