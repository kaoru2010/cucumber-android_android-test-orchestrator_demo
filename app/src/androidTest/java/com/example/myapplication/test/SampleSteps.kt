package com.example.myapplication.test

import io.cucumber.java.en.Given

class SampleSteps {
    @Given("something")
    fun something() {
        assert(true)
    }

    @Given("something2")
    fun something2() {
        assert(false)
    }
}
