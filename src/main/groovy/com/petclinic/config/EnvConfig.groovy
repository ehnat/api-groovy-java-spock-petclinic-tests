package com.petclinic.config

import org.aeonbits.owner.Config
import org.aeonbits.owner.Config.Sources
import org.aeonbits.owner.Config.Key

@Sources('classpath:env/${env}.properties')
interface EnvConfig extends Config {

    @Key('base-url')
    String baseUrl()
}
