package com.gfgDemo.WalletService;

import com.sun.net.httpserver.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
public class WalletController {
    private static final Logger logger = LoggerFactory.getLogger(WalletDto.class);

    @Autowired
    private WalletService walletService;

    @PostMapping
    public WalletDto addWallet(@RequestBody WalletDto walletDto, @RequestHeader String requestId){
        //MDC.put("requestId",requestId);
        logger.info("Request for wallet creation "+walletDto);
       return  walletService.addWallet(walletDto);
    }
}
