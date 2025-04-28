package com.pavan.core.services.impl;

import org.osgi.service.component.annotations.Component;

import com.pavan.core.services.PracticeOCDService;
//import com.pavan.core.services.PracticeService;


@Component(service=PracticeOCDService.class)
public class PracticeOCDServiceimpl  implements PracticeOCDService{

    @Override
    public String getName() {
        return "pavan kalyan mogeeli";
    }
}