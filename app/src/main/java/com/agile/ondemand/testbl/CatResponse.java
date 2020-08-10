package com.agile.ondemand.testbl;

import com.agile.ondemand.model.ServiceAds;

public class CatResponse {

    private ServiceAds serviceAds;

    public CatResponse(ServiceAds serviceAds) {
        this.serviceAds = serviceAds;
    }

    public ServiceAds getServiceAds() {
        return serviceAds;
    }
}
