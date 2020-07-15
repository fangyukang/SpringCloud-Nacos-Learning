package com.zoey.learning.seataorder.service;


import com.zoey.learning.commons.result.ApiResult;
import com.zoey.learning.seataorder.service.impl.FeignTAccountServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "seata-account-service", fallback = FeignTAccountServiceImpl.class)
public interface FeignTAccountService {


    //远程减库存
    @PostMapping(value = "/account/decrease")
    ApiResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") Double money);


    //主键查询账户
    @GetMapping("/account/get/{id}")
    ApiResult getAccount(@PathVariable("id") Long id);
}
