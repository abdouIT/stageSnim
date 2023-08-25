package com.stagiaireapp.service.Interfaces;

import com.stagiaireapp.Model.Direction;

import java.util.List;

public interface IDirection {

    public List<Direction> getAllDirection();

    public  Direction save(Direction direction);

    public Direction getDirectionById(Long id);

    public Direction updateDirection(Long id , Direction direction);

    public  void deleteDirection(Long id);
}
