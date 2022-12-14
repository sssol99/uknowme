package com.ssafy.uknowme.web.controller;


import com.ssafy.uknowme.model.dto.balanceDto.BalanceListResponseDto;
import com.ssafy.uknowme.model.dto.balanceDto.BalanceResponseDto;
import com.ssafy.uknowme.model.dto.balanceDto.BalanceSaveRequestDto;
import com.ssafy.uknowme.model.dto.balanceDto.BalanceUpdateRequestDto;
import com.ssafy.uknowme.web.service.BalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/feature/balance")
@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @PostMapping("/create")
    @Secured("ROLE_MANAGER")
    public boolean save(@RequestBody BalanceSaveRequestDto requestDto) {
        balanceService.save(requestDto);
        return true;
    }

    @PutMapping("/{balanceSeq}")
    @Secured("ROLE_MANAGER")
    public boolean update(@PathVariable int balanceSeq, @RequestBody BalanceUpdateRequestDto requestDto) {
        balanceService.update(balanceSeq, requestDto);
        return true;
    }

    @GetMapping("/random")
    public BalanceResponseDto findByBalanceSeq() {
        BalanceResponseDto balanceResponseDto = balanceService.findByBalanceSeq();
        return balanceResponseDto;
    }

    @GetMapping("/list")
    public List<BalanceListResponseDto> findAll() {
        List<BalanceListResponseDto> balances = balanceService.findAll();
        return balances;
    }


    @DeleteMapping("/{balanceSeq}")
    public boolean delete(@PathVariable int balanceSeq) {
        balanceService.delete(balanceSeq);
        return true;
    }
}
