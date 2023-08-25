package com.stagiaireapp.Controller;


import com.stagiaireapp.Model.Stage;
import com.stagiaireapp.service.Classes.Stagelmp;
import com.stagiaireapp.service.Interfaces.IStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Stage")
public class StageController {
    @Autowired
    private IStage iStage;
    @Autowired
    private Stagelmp stagelmp;

    @GetMapping
    public List<Stage> getAllStage(){return iStage.getAllStage();}

    @GetMapping("{id}")
    public Stage getStageById(@PathVariable Long id) {
        Stage stage = stagelmp.getStageById(id);
        return stage;
    }

    @PostMapping
    public  Stage CreateStage(@RequestBody Stage stage){
        Stage stage1 = stagelmp.saveStage(stage);
        return stage1;
    }

   @PutMapping("/{id}")
    public ResponseEntity<Stage> updateStage(@PathVariable Long id, @RequestBody Stage stage){
        Stage updateStage = stagelmp.updateStage(id, stage);
        return new ResponseEntity<>(updateStage, HttpStatus.OK);
    }



    @DeleteMapping
    public void deleteStage(@PathVariable Long id){stagelmp.deleteStage(id);}
}
