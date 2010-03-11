package scrum.client;

public class GScrumComponentsReflector implements ilarkesto.core.scope.ComponentReflector {

    protected ilarkesto.core.scope.ComponentReflector systemMessageManagerReflector = createSystemMessageManagerReflector();

    protected ilarkesto.core.scope.ComponentReflector calendarReflector = createCalendarReflector();

    protected ilarkesto.core.scope.ComponentReflector chatReflector = createChatReflector();

    protected ilarkesto.core.scope.ComponentReflector usersStatusReflector = createUsersStatusReflector();

    protected ilarkesto.core.scope.ComponentReflector wikiReflector = createWikiReflector();

    protected ilarkesto.core.scope.ComponentReflector pingerReflector = createPingerReflector();

    protected ilarkesto.core.scope.ComponentReflector uploaderReflector = createUploaderReflector();

    protected ilarkesto.core.scope.ComponentReflector changeHistoryManagerReflector = createChangeHistoryManagerReflector();

    protected ilarkesto.core.scope.ComponentReflector searchReflector = createSearchReflector();

    protected ilarkesto.core.scope.ComponentReflector undoReflector = createUndoReflector();

    protected ilarkesto.core.scope.ComponentReflector dndManagerReflector = createDndManagerReflector();

    public void injectComponents(Object component, ilarkesto.core.scope.Scope scope) {
        if (component instanceof scrum.client.admin.SystemMessageManager) systemMessageManagerReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.calendar.Calendar) calendarReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.collaboration.Chat) chatReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.collaboration.UsersStatus) usersStatusReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.collaboration.Wiki) wikiReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.communication.Pinger) pingerReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.files.Uploader) uploaderReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.journal.ChangeHistoryManager) changeHistoryManagerReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.search.Search) searchReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.undo.Undo) undoReflector.injectComponents(component, scope);
        if (component instanceof scrum.client.workspace.DndManager) dndManagerReflector.injectComponents(component, scope);
    }

    public void callInitializationMethods(Object component) {
        if (component instanceof scrum.client.admin.SystemMessageManager) systemMessageManagerReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.calendar.Calendar) calendarReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.collaboration.Chat) chatReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.collaboration.UsersStatus) usersStatusReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.collaboration.Wiki) wikiReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.communication.Pinger) pingerReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.files.Uploader) uploaderReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.journal.ChangeHistoryManager) changeHistoryManagerReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.search.Search) searchReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.undo.Undo) undoReflector.callInitializationMethods(component);
        if (component instanceof scrum.client.workspace.DndManager) dndManagerReflector.callInitializationMethods(component);
    }

    public void outjectComponents(Object component, ilarkesto.core.scope.Scope scope) {
        if (component instanceof scrum.client.admin.SystemMessageManager) systemMessageManagerReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.calendar.Calendar) calendarReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.collaboration.Chat) chatReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.collaboration.UsersStatus) usersStatusReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.collaboration.Wiki) wikiReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.communication.Pinger) pingerReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.files.Uploader) uploaderReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.journal.ChangeHistoryManager) changeHistoryManagerReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.search.Search) searchReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.undo.Undo) undoReflector.outjectComponents(component, scope);
        if (component instanceof scrum.client.workspace.DndManager) dndManagerReflector.outjectComponents(component, scope);
    }

    public ilarkesto.core.scope.ComponentReflector createSystemMessageManagerReflector() {
        return new scrum.client.admin.GSystemMessageManagerReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createCalendarReflector() {
        return new scrum.client.calendar.GCalendarReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createChatReflector() {
        return new scrum.client.collaboration.GChatReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createUsersStatusReflector() {
        return new scrum.client.collaboration.GUsersStatusReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createWikiReflector() {
        return new scrum.client.collaboration.GWikiReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createPingerReflector() {
        return new scrum.client.communication.GPingerReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createUploaderReflector() {
        return new scrum.client.files.GUploaderReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createChangeHistoryManagerReflector() {
        return new scrum.client.journal.GChangeHistoryManagerReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createSearchReflector() {
        return new scrum.client.search.GSearchReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createUndoReflector() {
        return new scrum.client.undo.GUndoReflector();
    }

    public ilarkesto.core.scope.ComponentReflector createDndManagerReflector() {
        return new scrum.client.workspace.GDndManagerReflector();
    }

}

