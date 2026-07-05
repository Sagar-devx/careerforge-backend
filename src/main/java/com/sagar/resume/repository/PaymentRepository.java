package com.sagar.resume.repository;

import com.sagar.resume.document.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends MongoRepository<Payment,String> {

    Optional<Payment> findByRazorPayOrderId(String razorPayOrderId);

    Optional<Payment>findByRazorPayPaymentId(String razorpayPaymentId);

    List<Payment> findByUserIdOrderByCreatedAtDesc(String userId);

    List<Payment> findByStatus(String status);
}
