package com.example.myapplication.test

import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
    plugin = [
        BuildConfig.CUCUMBER_JSON_PLUGIN,
        "com.example.myapplication.test.CopyReportToTestStoragePlugin",
    ]
)
class CucumberConfig
