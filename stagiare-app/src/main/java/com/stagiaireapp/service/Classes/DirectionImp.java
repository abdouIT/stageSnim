package com.stagiaireapp.service.Classes;

import com.stagiaireapp.Model.Direction;
import com.stagiaireapp.Repository.DirectionRepository;
import com.stagiaireapp.service.Interfaces.IDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DirectionImp implements IDirection {
    @Autowired
    private DirectionRepository directionRepository;
    @Override
    public List<Direction> getAllDirection() {
        return directionRepository.findAll();
    }
    @Override
    public Direction save(Direction direction) {
        return directionRepository.save(direction);
    }

    @Override
    public Direction getDirectionById(Long id) {
        return directionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
    }
    @Override
    public Direction updateDirection(Long id, Direction direction) {
        Direction existingDirection = directionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Fund"));

        existingDirection.setNomdirection(direction.getNomdirection()); // Update the field

        return directionRepository.save(existingDirection); // Save and return the updated entity
    }


    @Override
    public void deleteDirection(Long id) { directionRepository.deleteById(id);
    }
}
