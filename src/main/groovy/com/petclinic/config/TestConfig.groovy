package com.petclinic.config

import groovy.transform.CompileStatic
import org.aeonbits.owner.ConfigFactory

@CompileStatic
class TestConfig {

    private final EnvConfig envConfigVar = ConfigFactory.create(EnvConfig, [env: System.getProperty('env')])

    static EnvConfig getEnvConfig() {
        LazyHolder.INSTANCE.envConfigVar
    }

    private static class LazyHolder {

        private static final TestConfig INSTANCE = new TestConfig()
    }
}
