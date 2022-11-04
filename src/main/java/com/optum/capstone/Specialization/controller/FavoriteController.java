package com.optum.capstone.Specialization.controller;

import com.optum.capstone.Specialization.dtos.FavoriteDto;
import com.optum.capstone.Specialization.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/customer/{customerId}")
    public List<FavoriteDto> getAllFavoritesByCustomerId(@PathVariable Long customerId){
        return favoriteService.getAllFavoritesByCustomerId(customerId);
}
    @GetMapping("/{favoriteId}")
    public Optional<FavoriteDto> getFavoriteById(@PathVariable Long favoriteId){
        return favoriteService.getFavoriteById(favoriteId);
    }

    @PostMapping("/customer/{customerId}")
    public void addFavorite(@RequestBody FavoriteDto favoriteDto,@PathVariable Long customerId){
        favoriteService.addFavorite(favoriteDto, customerId);
    }

    @DeleteMapping("/{favoriteId}")
    public void deleteFavoriteById(@PathVariable Long favoriteId){
        favoriteService.deleteFavoriteById(favoriteId);
    }

    @PutMapping
    public void updateFavorite(@RequestBody FavoriteDto favoriteDto){
        favoriteService.updateFavoriteById(favoriteDto);
    }
}


