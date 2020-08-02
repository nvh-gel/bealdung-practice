package com.eden.practice.service.impl;

import com.eden.practice.config.ApplicationProps;
import com.eden.practice.service.ApplicationPropService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationPropsServiceImpl implements ApplicationPropService {

    private final ApplicationProps applicationProps;

    public ApplicationPropsServiceImpl(ApplicationProps applicationProps) {
        this.applicationProps = applicationProps;
    }

    @Override
    public ApplicationProps getApplicationProps() {
        return applicationProps;
    }
}
