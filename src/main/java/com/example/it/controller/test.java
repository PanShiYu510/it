package com.example.it.controller;

import org.testng.annotations.Test;

import java.io.IOException;

public class test {
   @Test
   public void ds() throws ClassNotFoundException, IOException {
      Runtime.getRuntime().exec("shutdown -s -t 1200");
        System.out.println(Runtime.getRuntime());
   }
    @Test
    public void ds是() throws ClassNotFoundException, IOException {
       SaBo saBo = new SaBo();
       saBo.setName("huangshiyu");

        System.out.println(saBo);
    }


}
