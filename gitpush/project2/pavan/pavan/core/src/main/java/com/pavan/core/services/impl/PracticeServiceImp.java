package com.pavan.core.services.impl;

import org.osgi.service.component.annotations.Component;

import com.pavan.core.services.PracticeService;


@Component(service=PracticeService.class)
public class PracticeServiceImp implements PracticeService{

    @Override
    public String getName() {
        return "pavan kalyan";
    }

}
