package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testGreet() {
        Main main = new Main();
        var greeting  = main.greet("Ashish");
        assertEquals("Hello, Ashish", greeting);
    }
}