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
        List<Provider> list = providerService.selectProviderList(provider);
        model.addAttribute("provider",provider);
        model.addAttribute("providerList",list);
        return "providerlist";
    }

    @RequestMapping(value = "/providerview")
    public String providerView(Model model,Long id){
        Provider provider = providerService.selectProviderById(id);
        model.addAttribute("provider",provider);
        return "providerview";
    }

    @RequestMapping(value = "/providermodify")
    public String providerModify(Model model,Provider provider){
        Provider pro = providerService.selectProviderById(provider.getId());
        model.addAttribute("provider",pro);
        return "providermodify";
    }

    @RequestMapping(value = "/providerModify")
    public String providerModify(Provider provider){
        int i = providerService.updateProvider(provider);
        if(i==1){
            return "redirect:providerlist";
        }else{
            return "forward:providermodify";
        }
    }

    @RequestMapping(value = "/providerdelete")
    public String providerDelete(Model model,Long id){
        int i = providerService.deleteProvider(id);
        return "forward:providerlist";
    }

    @RequestMapping(value = "/provideradd")
    public String providerAdd(){
        return "provideradd";
    }

    @RequestMapping(value = "/providerAdd")
    public String providerAdd(Provider provider){
        int i = providerService.insertProvider(provider);
        return "redirect:providerlist";
    }
}
