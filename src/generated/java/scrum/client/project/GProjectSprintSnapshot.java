









// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtEntityGenerator










package scrum.client.project;

import java.util.*;

public abstract class GProjectSprintSnapshot
            extends scrum.client.common.AGwtEntity {

    public GProjectSprintSnapshot() {
    }

    public GProjectSprintSnapshot(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "projectSprintSnapshot";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- date ---

    private scrum.client.common.Date date ;

    public final scrum.client.common.Date getDate() {
        return this.date ;
    }

    public final ProjectSprintSnapshot setDate(scrum.client.common.Date date) {
        this.date = date ;
        propertyChanged("date", this.date);
        return (ProjectSprintSnapshot)this;
    }

    public final boolean isDate(scrum.client.common.Date date) {
        return equals(this.date, date);
    }

    // --- project ---

    private String projectId;

    public final scrum.client.project.Project getProject() {
        return getDao().getProject(this.projectId);
    }

    public final ProjectSprintSnapshot setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (equals(this.projectId, id)) return (ProjectSprintSnapshot) this;
        this.projectId = id;
        propertyChanged("projectId", this.projectId);
        return (ProjectSprintSnapshot)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        return equals(this.projectId, project);
    }

    // --- burnedWork ---

    private int burnedWork ;

    public final int getBurnedWork() {
        return this.burnedWork ;
    }

    public final ProjectSprintSnapshot setBurnedWork(int burnedWork) {
        this.burnedWork = burnedWork ;
        propertyChanged("burnedWork", this.burnedWork);
        return (ProjectSprintSnapshot)this;
    }

    public final boolean isBurnedWork(int burnedWork) {
        return equals(this.burnedWork, burnedWork);
    }

    // --- remainingWork ---

    private int remainingWork ;

    public final int getRemainingWork() {
        return this.remainingWork ;
    }

    public final ProjectSprintSnapshot setRemainingWork(int remainingWork) {
        this.remainingWork = remainingWork ;
        propertyChanged("remainingWork", this.remainingWork);
        return (ProjectSprintSnapshot)this;
    }

    public final boolean isRemainingWork(int remainingWork) {
        return equals(this.remainingWork, remainingWork);
    }

    // --- update properties by map ---

    public void updateProperties(Map props) {
        String dateAsString = (String) props.get("date");
        date  =  dateAsString == null ? null : new scrum.client.common.Date(dateAsString);
        projectId = (String) props.get("projectId");
        burnedWork  = (Integer) props.get("burnedWork");
        remainingWork  = (Integer) props.get("remainingWork");
    }

    @Override
    public void storeProperties(Map properties) {
        super.storeProperties(properties);
        properties.put("date", this.date == null ? null : this.date.toString());
        properties.put("projectId", this.projectId);
        properties.put("burnedWork", this.burnedWork);
        properties.put("remainingWork", this.remainingWork);
    }

}
