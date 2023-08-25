package com.stagiaireapp.Controller;

import com.stagiaireapp.Repository.DirectionRepository;
import com.stagiaireapp.Model.Direction;
import com.stagiaireapp.service.Classes.DirectionImp;
import com.stagiaireapp.service.Interfaces.IDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Direction")
public class DirectionController {
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private DirectionImp directionImp;
    /**
     * endpoint: pour Lister les Direction par Id
     * @return
     */

    @GetMapping
    public List<Direction> getAllDirection() {
        return directionImp.getAllDirection();
    }

    /**
     * endpoint: pour cree les Directions
     * @return
     */
    @PostMapping
    public Direction CreateDirection(@RequestBody Direction direction) {
        Direction direction1 = directionImp.save(direction);
        return direction1;
    }

    /**
     * endpoint: pour Lister les Directions par Id
     * @return
     */

    @GetMapping("{id}")
    public Direction getDirectionById(@PathVariable Long id) {
        Direction direction = directionImp.getDirectionById(id);
        return direction;
    }

    /**
     * endpoint: pour Modifiier les Direction par Id
     * @return
     */

    @PutMapping("/{id}") // Use a proper URI pattern with curly braces
    public ResponseEntity<Direction> updateDirection(@PathVariable Long id, @RequestBody Direction direction) {
        Direction updatedDirection = directionImp.updateDirection(id, direction);
        return new ResponseEntity<>(updatedDirection, HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public  void deleteDirection(@PathVariable Long id){
        directionImp.deleteDirection(id);
    }
}