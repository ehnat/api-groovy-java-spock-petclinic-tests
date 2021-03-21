package com.petclinic.config

import org.aeonbits.owner.ConfigFactory

class TestConfig {

    private final EnvConfig envConfigVar = ConfigFactory.create(EnvConfig.class, [env: System.getProperty('env')])

    static EnvConfig getEnvConfig() {
        LazyHolder.INSTANCE.envConfigVar
    }

    private static class LazyHolder {
        private static final TestConfig INSTANCE = new TestConfig()
    }
}
