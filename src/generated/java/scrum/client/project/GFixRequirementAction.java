// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtActionGenerator










package scrum.client.project;

import java.util.*;

public abstract class GFixRequirementAction
            extends scrum.client.common.AScrumAction {

    protected scrum.client.project.Requirement requirement;

    public GFixRequirementAction(scrum.client.project.Requirement requirement) {
        this.requirement = requirement;
    }

    @Override
    public boolean isExecutable() {
        return true;
    }

}