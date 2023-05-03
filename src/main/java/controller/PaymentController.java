package controller;

import org.springframework.web.bind.annotation.*;
import pojo.PaymentRequest;
import pojo.Response;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final String apiKey = "API_KEY";
    private final String success_status = "success";
    private final String error_status = "error";
    private final int code_success = 100;
    private final int code_error = 102;


    @GetMapping
    public Response showStatus() {
        return new Response(success_status, 1);
    }


    @PostMapping("/pay")
    public Response pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
        final Response response;

        if (apiKey.equalsIgnoreCase(key)){
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();
            // Process the request
            // ....
            // Return success response to the client.
            response = new Response(success_status, code_success);
        } else {
            response = new Response(error_status, code_error);
        }
        return response;
    }



}
