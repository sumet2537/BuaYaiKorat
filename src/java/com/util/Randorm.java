/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.util.Random;

/**
 *
 * @author Donut
 */
public class Randorm {
        public String getRandomCode() {
        String defultCode = "1234567890abcdefghijklmnopqstuvxyz";
        StringBuilder sumCode = new StringBuilder();
        Random random = new Random();
        while (sumCode.length() < 8 ) {
            int index = (int) (random.nextFloat() * defultCode.length());
            sumCode.append(defultCode.charAt(index));
        }
        String resultCode = sumCode.toString();
        return resultCode;

    }
    public static void main(String[] args) {
        Randorm random = new Randorm();
        String osaka = random.getRandomCode();
        System.out.println("osaka   = = = = = =" + osaka);
        
    }

    
}
