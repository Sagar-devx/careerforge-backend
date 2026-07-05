package com.sagar.resume.controller;

import com.razorpay.RazorpayException;
import com.sagar.resume.document.Payment;
import com.sagar.resume.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.sagar.resume.dto.OrderRequest;
import com.sagar.resume.dto.PaymentVerificationRequest;

import static com.sagar.resume.util.AppConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PAYMENT)
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(CREATE_ORDER)
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request, Authentication authentication) throws RazorpayException {

        String planType = request.getPlanType();

        if(!PREMIUM.equalsIgnoreCase(planType))
        {
            return ResponseEntity.badRequest().body(Map.of("message","Invalid Plan type"));
        }

       Payment payment=paymentService.createOrder(authentication.getPrincipal(),planType);

        Map<String,Object> response =Map.of(
                "orderId",payment.getRazorPayOrderId(),
                "amount",payment.getAmount(),
                "currency",payment.getCurrency(),
                "recipt",payment.getReceipt()
        );

        return ResponseEntity.ok(response);

    }

    @PostMapping(VERIFY_PAYMENT)
    public ResponseEntity<?> verifyPayment(@RequestBody PaymentVerificationRequest request)
    {
       String razorpayOrderId = request.getRazorpayOrderId();
       String razorpayPaymentId = request.getRazorpayPaymentId();
       String razorpaySignature = request.getRazorpaySignature();

       if(Objects.isNull(razorpayPaymentId) || Objects.isNull(razorpayOrderId) || Objects.isNull(razorpaySignature))
       {
           return  ResponseEntity.badRequest().body(Map.of("message","Missing required payment parameters"));
       }

       boolean isValid = paymentService.verifyPayment(razorpayOrderId, razorpayPaymentId, razorpaySignature);

       if(isValid)
       {
           return ResponseEntity.ok(Map.of(
                   "message","Payment verified successfully",
                   "status","success")
           );
       }
       else {
            return ResponseEntity.badRequest().body(Map.of("message","Payment verification failed"));
       }

    }

    @GetMapping
    public ResponseEntity<?> getPaymentHistory(Authentication authentication)
    {
       List<Payment> paymentList= paymentService.getUserPayments(authentication.getPrincipal());

       return ResponseEntity.ok(paymentList);

    }

    @GetMapping(ORDER_ID)
    public ResponseEntity<?> getOrderDetails(@PathVariable("orderId") String orderId)
    {
        Payment paymentDetails =paymentService.getPaymentDetails(orderId);

        return  ResponseEntity.ok(paymentDetails);

    }

    @GetMapping("/test-signature")
    public ResponseEntity<?> getTestSignature(@RequestParam("orderId") String orderId, @RequestParam("paymentId") String paymentId) {
        String signature = paymentService.generateTestSignature(orderId, paymentId);
        return ResponseEntity.ok(Map.of("signature", signature));
    }
}
