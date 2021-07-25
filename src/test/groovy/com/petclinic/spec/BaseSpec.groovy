package com.petclinic.spec

import com.anotherchrisberry.spock.extensions.retry.RetryOnFailure
import spock.lang.Specification

@RetryOnFailure(times = 1, delaySeconds = 5)
class BaseSpec extends Specification {

}
