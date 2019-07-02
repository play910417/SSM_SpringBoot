package com.bdqn.ssm_springboot.pojo;

public class BillCustom extends Bill {
    private Provider provider;
    private String isPay;

    public String getIsPay() {
        if(getIsPayment()==1){
            this.isPay="未付款";
        }else{
            this.isPay="已付款";
        }
        return isPay;
    }

    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
