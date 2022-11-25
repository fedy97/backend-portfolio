package com.fedy97.springbootserver.services.interfaces;

import com.fedy97.springbootserver.payload.request.VoidRequest;
import com.fedy97.springbootserver.payload.response.PortfolioResponse;

import java.util.List;


public interface IPortfolioService {
    PortfolioResponse getPortfolio(VoidRequest voidRequest);

}
