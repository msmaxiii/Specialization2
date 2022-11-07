package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.FavoriteDto;
import com.optum.capstone.Specialization.entities.User;
import com.optum.capstone.Specialization.entities.Favorite;
import com.optum.capstone.Specialization.repositories.FavoriteRepository;
import com.optum.capstone.Specialization.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService{

  @Autowired
    private UserRepository userRepository;

@Autowired
    private FavoriteRepository favoriteRepository;

   @Override
    public void addFavorite(FavoriteDto favoriteDto, Long userId){

        Optional<User> userOptional = userRepository.findById(userId);
        Favorite favorite = new Favorite(favoriteDto);
        userOptional.ifPresent(favorite::setUser); // it's same as note.set user(user optional)
        favoriteRepository.saveAndFlush(favorite);
    }

    @Override
    public void deleteFavoriteById(Long favoriteId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteId);
        favoriteOptional.ifPresent(favorite -> favoriteRepository.delete(favorite));
    }

   @Override
    public void updateFavoriteById(FavoriteDto favoriteDto) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteDto.getId() );
        favoriteOptional.ifPresent(favorite -> {
            favorite.setBody(favoriteDto.getBody());
            favoriteRepository.saveAndFlush(favorite);
            //use the note detail to make some other logic changes
        });
    }

   @Override
    public List<FavoriteDto> getAllFavoritesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            List<Favorite> favoriteList = favoriteRepository.findAllByUserEquals(userOptional.get());

            return favoriteList.stream().map(favorite -> new FavoriteDto(favorite)).collect(Collectors.toList());

        }
        return Collections.emptyList();
    }

    @Override
    public Optional<FavoriteDto> getFavoriteById(Long favoriteId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteId);
        if(favoriteOptional.isPresent()){
            return Optional.of(new FavoriteDto(favoriteOptional.get()));
        }
        return Optional.empty();
    }

}