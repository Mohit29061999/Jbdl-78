package com.gfgDemo.WalletService;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WalletDto {

    private Integer userId;
    private Double balance;
}
