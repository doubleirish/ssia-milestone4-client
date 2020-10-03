package com.manning.ssia.milestone4_client.service;

import com.manning.ssia.milestone4_client.domain.HealthAdvice;
import com.manning.ssia.milestone4_client.domain.HealthProfile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AdviceService {


    private List<String> demoAdviceList =  List.of(
            "Go easy on the doughnuts",
            "Reduce your salt consumption",
            "Drink more water",
            "Add more fiber to your diet",
            "Take a walk every day",
            "Eat more fruits & veggies"
            );
    public HealthAdvice generate(HealthProfile hp) {
        Random rand = new Random();
        int randIndex= rand.nextInt(demoAdviceList.size());
        return new HealthAdvice(hp.getUsername(), demoAdviceList.get(randIndex));
    }
}