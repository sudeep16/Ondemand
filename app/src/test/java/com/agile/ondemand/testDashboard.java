package com.agile.ondemand;

import com.agile.ondemand.model.ServiceAds;
import com.agile.ondemand.model.User;

import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class testDashboard {


    @Test
    public void addNewService(){
        ServiceAds serviceAds = new ServiceAds("","","","","","","");
        AddOrderLogic addOrderLogic = new AddOrderLogic("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1ZDA4OTgxZmU5YzU5NDNhODRkYmIzYTciLCJpYXQiOjE1NjI3Njc3ODh9.fgeVkcBf7gZ_AW0e8_ZgV3Lp5zJ0f3UZpQMmq-PIrRk",orderModel);

        boolean status = addOrderLogic.addNewOrder();
        assertThat(status,is(true));

    }



    @Test
    public void testSortingCategory(){



    }
    @Test
    public void testSortingJobs(){



    }



}
