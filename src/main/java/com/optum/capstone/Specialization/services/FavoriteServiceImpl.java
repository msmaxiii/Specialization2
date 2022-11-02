package com.optum.capstone.Specialization.services;

import com.optum.capstone.Specialization.dtos.FavoriteDto;
import com.optum.capstone.Specialization.dtos.CustomerDto;
import com.optum.capstone.Specialization.entities.Favorite;
import com.optum.capstone.Specialization.entities.Customer;
import com.optum.capstone.Specialization.repositories.FavoriteRepository;
import com.optum.capstone.Specialization.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List*;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;


    @Override

    public void addCustomerFavorite(FavoriteDto favoriteDto, Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Favorite favorite = new Favorite(favoriteDto);
        customerOptional.ifPresent(favorite::setCustomer);
        favoriteRepository.saveAndFlush(favorite);
    }

    @Override

    public void deleteFavoriteById(Long favoriteId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteId);
        favoriteOptional.ifPresent(favorite -> favoriteRepository.delete(favorite));
    }




    @Override

    public void updateFavoriteById(FavoriteDto favoriteDto) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteDto.getId());
        favoriteOptional.ifPresent(favorite -> {
            favorite.setFavorite(favoriteDto.getFavorite());
            favoriteRepository.saveAndFlush(favorite);
        });
    }

    @Override
    public List<FavoriteDto> getAllFavoritesByCustomerId(Long customerId){
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()){
            List<Customer> favoriteList = favoriteRepository.findAllByCustomerEquals(customerOptional.get());
            return favoriteList.stream().map(favorite -> new FavoriteDto(favorite)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<FavoriteDto> getFavoriteById(Long favoriteId) {
        Optional<Favorite> favoriteOptional = favoriteRepository.findById(favoriteId);
        if (favoriteOptional.isPresent()){
            return Optional.of(new FavoriteDto(favoriteOptional.get()));
        }
        return Optional.empty();
    }
}



