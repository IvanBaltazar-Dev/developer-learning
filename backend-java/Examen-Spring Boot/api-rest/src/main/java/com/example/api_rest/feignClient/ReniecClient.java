package com.example.api_rest.feignClient;

import com.example.api_rest.dto.response.ReniecResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reniec-veterinaria-client", url = "${app.reniec.base-url}")
public interface ReniecClient {

    @GetMapping("/v1/reniec/dni")
    ReniecResponse getPersonaInfo(
            @RequestParam("numero") String numero,
            @RequestHeader("Authorization") String authorization
    );
}
