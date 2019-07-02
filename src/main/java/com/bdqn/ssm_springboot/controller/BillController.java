package com.bdqn.ssm_springboot.controller;

import com.bdqn.ssm_springboot.pojo.Bill;
import com.bdqn.ssm_springboot.pojo.BillCustom;
import com.bdqn.ssm_springboot.pojo.Provider;
import com.bdqn.ssm_springboot.service.BillService;
import com.bdqn.ssm_springboot.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BillController {
    @Resource
    private BillService billService;
    @Resource
    private ProviderService providerService;

    @RequestMapping(value = "/billlist")
    public String billList(Model model, Bill bill){
        List<BillCustom> list = billService.selectBillList(bill);
        model.addAttribute("list",list);
        List<Provider> providers = providerService.selectProviderList(null);
        model.addAttribute("providers",providers);
        model.addAttribute("bill",bill);
        return "billlist";
    }
}
