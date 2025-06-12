package com.dachiabashidze.user_service.service;
import com.dachiabashidze.user_service.entity.OrderDTO;
import com.dachiabashidze.user_service.entity.User;
import com.dachiabashidze.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final WebClient webClient;
    public UserService(UserRepository userRepository,WebClient.Builder webClientBuilder){
        this.userRepository = userRepository;
        this.webClient = webClientBuilder.build();
}
    public List<User> getAllUsers() {

        return new ArrayList<>(userRepository.findAll());
    }

    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public List<OrderDTO> getUserOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String userName = user.getName();

        return webClient.get()
                .uri("http://order-service/orders/username/{userName}", userName)
                .retrieve()
                .bodyToFlux(OrderDTO.class)   
                .collectList()               
                .block();                     
    }



}

