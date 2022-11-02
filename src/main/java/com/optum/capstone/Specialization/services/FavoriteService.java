package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.FavoriteDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface FavoriteService {

    @Transactional
    void addFavorite(FavoriteDto favoriteDto, Long customerId);

    @Transactional
    void deleteFavoriteById(Long favoriteId);

    @Transactional
    void updateFavoriteById(FavoriteDto favoriteDto);
    List<FavoriteDto> getAllFavoritesByCustomerId(Long customerId);

    Optional<FavoriteDto> getFavoriteById(Long favoriteId);
}
