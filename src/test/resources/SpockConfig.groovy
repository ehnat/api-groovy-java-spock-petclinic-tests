import com.petclinic.common.testgroups.Regression
import com.petclinic.common.testgroups.Smoke

Class<?>[] map(String groups) {
    Map nameToAnnotation = [
            'Smoke'     : Smoke,
            'Regression': Regression
    ]

    return Arrays.stream(groups.split(','))
            .filter { !it.isAllWhitespace() }
            .map(nameToAnnotation::get)
            .toArray(size -> new Class[size])
}

runner {
    String includedGroupsCsv = System.getProperty('included.test.groups')
    String excludedGroupsCsv = System.getProperty('excluded.test.groups')

    println("Include: $includedGroupsCsv")
    println("Exclude: $excludedGroupsCsv")

    include map(includedGroupsCsv)
    exclude map(excludedGroupsCsv)
}
