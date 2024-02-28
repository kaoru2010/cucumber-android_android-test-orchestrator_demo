package com.example.myapplication.test

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.services.storage.TestStorage
import io.cucumber.plugin.EventListener
import io.cucumber.plugin.event.EventHandler
import io.cucumber.plugin.event.EventPublisher
import io.cucumber.plugin.event.TestRunFinished
import java.util.UUID

class CopyReportToTestStoragePlugin : EventListener {
    override fun setEventPublisher(publisher: EventPublisher) {
        publisher.registerHandlerFor(TestRunFinished::class.java, OnTestRunFinished())
    }

    class OnTestRunFinished : EventHandler<TestRunFinished> {
        override fun receive(event: TestRunFinished?) {
            val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
            targetContext.openFileInput("cucumber.json").use { inputStream ->
                TestStorage().openOutputFile("cucumber-${UUID.randomUUID()}.json").use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        }
    }
}
