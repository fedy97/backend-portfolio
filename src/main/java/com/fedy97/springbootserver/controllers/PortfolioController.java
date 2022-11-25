package com.fedy97.springbootserver.controllers;

import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.PortfolioResponse;
import com.fedy97.springbootserver.services.interfaces.IPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    private IPortfolioService portfolioService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("")
    public ResponseEntity<PortfolioResponse> getAllPortfolios() {
        VoidRequest voidRequest = new VoidRequest();
        voidRequest.setSort(new String[]{"startYear", "desc"});
        return ResponseEntity.ok(portfolioService.getPortfolio(voidRequest));
    }
}
