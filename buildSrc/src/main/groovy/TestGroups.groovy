class TestGroups {
    private static final groupDefinitions = [
            "regression": "com.petclinic.common.testgroups.Regression",
            "smoke"     : "com.petclinic.common.testgroups.Smoke"
    ]

    private final Collection<String> groupsParam

    TestGroups(String groupsString) {
        groupsParam = (groupsString ?: "")
                .split(",")
                .toList()
                .findAll { !it.isAllWhitespace() }
    }

    String[] excludedGroups() {
        resolveGroups(excludes())
    }

    String[] includedGroups() {
        resolveGroups(includes())
    }

    private String[] resolveGroups(Collection<String> groups) {
        groups
                .collect { groupDefinitions[it] }
                .toArray(new String[groups.size()])
    }

    private Collection<String> includes() {
        groupsParam.findAll { !isExcluded(it) }
    }

    private Collection<String> excludes() {
        groupsParam
                .findAll { isExcluded(it) }
                .collect { it.replaceFirst("-", "") }
    }

    private boolean isExcluded(String group) {
        group.startsWith("-")
    }
}