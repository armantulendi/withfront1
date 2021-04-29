package com.example.withfront;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForExample {
    @Test
    void checkSumOfSimples() {
        int a=6;
        int b=4;
        Assertions.assertEquals(10,a+b);
        Assertions.assertEquals(24,a*b);
    }
}
