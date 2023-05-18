package dev.eyrond.paperkt.example

import dev.eyrond.paperkt.plugin.KotlinPlugin

class ExamplePlugin : KotlinPlugin() {

    override suspend fun loadConfig() {
        // Here load configuration for your plugin.
    }

    override suspend fun onEnabled() {
        // Initialization logic for your plugin.
    }

    override suspend fun onDisabled() {
        // Cleanup logic for your plugin.
    }
}
