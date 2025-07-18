package com.vishal.springBoot;

import org.springframework.stereotype.Component;

@Component
public class dep2 implements dep{
        @Override
        public String about()
        {
            return "Im dependency 2";
        }
    }
