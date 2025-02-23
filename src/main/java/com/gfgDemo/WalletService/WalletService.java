package com.gfgDemo.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public WalletDto addWallet(WalletDto walletDto) {
        Wallet wallet = Wallet.builder().
              userId(walletDto.getUserId())
                .balance(walletDto.getBalance())
        .build();
        walletRepository.save(wallet);
        return walletDto;
    }
}
