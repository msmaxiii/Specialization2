package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.FavoriteDto;
import com.optum.capstone.Specialization.entities.Customer;
import com.optum.capstone.Specialization.entities.Favorite;
import com.optum.capstone.Specialization.repositories.FavoriteRepository;
import com.optum.capstone.Specialization.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public void addFavorite(FavoriteDto favoriteDto, Long customerId){

        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Favorite favorite = new Favorite(favoriteDto);
        customerOptional.ifPresent(favorite::setCustomer); // it's same as note.set user(user optional)
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
//            favorite.setBody(favoriteDto.getBody());
            favoriteRepository.saveAndFlush(favorite);
            //use the note detail to make some other logic changes
        });
    }

    @Override
    public List<FavoriteDto> getAllFavoritesByCustomerId(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            List<Favorite> favoriteList = favoriteRepository.findAllByCustomerEquals(customerOptional.get());

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