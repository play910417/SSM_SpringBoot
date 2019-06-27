package com.bdqn.ssm_springboot.controller;

import com.bdqn.ssm_springboot.pojo.Provider;
import com.bdqn.ssm_springboot.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProviderController {
    @Resource
    private ProviderService providerService;

    @RequestMapping(value = "/providerlist")
    public String providerList(Model model, Provider provider){
        List<Provider> list = providerService.findProviderList(provider);
        model.addAttribute("provider",provider);
        model.addAttribute("providerList",list);
        return "providerlist";
    }

    @RequestMapping(value = "/providerview")
    public String providerView(Model model,Long id){
        Provider provider = providerService.findProviderById(id);
        model.addAttribute("provider",provider);
        return "providerview";
    }

    @RequestMapping(value = "/providermodify")
    public String providerModify(Model model,Long id){
        Provider provider = providerService.findProviderById(id);
        model.addAttribute("provider",provider);
        return "providermodify";
    }

    @RequestMapping(value = "/providerModify")
    public String providerModify(Model model,Provider provider){
        System.out.println(provider.getId());
        System.out.println("ceshi");
        return "redirect:providerlist";
    }
}
