package com.example.PowerUpGym.services;

import com.example.PowerUpGym.entity.payments.PaymentsEntity;
import com.example.PowerUpGym.entity.users.PlayersEntity;
import com.example.PowerUpGym.entity.users.UserEntity;
import com.example.PowerUpGym.repositories.PaymentsEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentsEntityRepository paymentsEntityRepository;

    public PaymentsEntity savePayment(PaymentsEntity payment) {
        return paymentsEntityRepository.save(payment);
    }

    public PaymentsEntity getPaymentByPlayer(PlayersEntity player) {
        UserEntity user = player.getUser();
        return paymentsEntityRepository.findByUserEntity(user);

    }
}
