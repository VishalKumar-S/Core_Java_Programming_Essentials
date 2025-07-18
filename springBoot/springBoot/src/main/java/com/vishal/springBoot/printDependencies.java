package com.vishal.springBoot;

import org.springframework.stereotype.Service;

@Service
public class printDependencies {
    public dep1 dependency1;
    public dep2 dependency2;
    public dep3 dependency3;

    public printDependencies(dep1 a, dep2 b, dep3 c){
        this.dependency1 = a;
        this.dependency2 = b;
        this.dependency3 = c;
    }


    public void print(){
        System.out.println(dependency1.about());
        System.out.println(dependency2.about());
        System.out.println(dependency3.about());
        System.out.println(dependency3.getAbout());
        System.out.println(dependency3.getAbout2());
    }



}
