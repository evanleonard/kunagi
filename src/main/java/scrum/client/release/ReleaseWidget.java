package scrum.client.release;

import ilarkesto.gwt.client.AMultiSelectionViewEditWidget;
import ilarkesto.gwt.client.AOutputViewEditWidget;
import ilarkesto.gwt.client.TableBuilder;
import scrum.client.ScrumGwt;
import scrum.client.common.AScrumWidget;
import scrum.client.issues.RequestReleaseIssuesServiceCall;
import scrum.client.journal.ChangeHistoryWidget;
import scrum.client.sprint.Sprint;

import com.google.gwt.user.client.ui.Widget;

public class ReleaseWidget extends AScrumWidget {

	private Release release;

	public ReleaseWidget(Release release) {
		super();
		this.release = release;
	}

	@Override
	protected Widget onInitialization() {
		new RequestReleaseIssuesServiceCall(release.getId()).execute();

		TableBuilder tb = ScrumGwt.createFieldTable();

		tb.addFieldRow("Label", release.getLabelModel());
		tb.addFieldRow("Release date", release.getReleaseDateModel());
		tb.addFieldRow("Description", release.getNoteModel());
		tb.addFieldRow("Release notes", release.getReleaseNotesModel());
		if (release.isMajor()) {
			tb.addFieldRow("Sprints", new AMultiSelectionViewEditWidget<Sprint>() {

				@Override
				protected void onViewerUpdate() {
					setViewerItems(release.getSprints());
				}

				@Override
				protected void onEditorUpdate() {
					setEditorItems(release.getProject().getSprints());
					setEditorSelectedItems(release.getSprints());
				}

				@Override
				protected void onEditorSubmit() {
					release.setSprints(getEditorSelectedItems());
				}

				@Override
				public boolean isEditable() {
					return release.getProject().isProductOwner(getCurrentUser());
				}
			});

			tb.addFieldRow("Sprints", new AOutputViewEditWidget() {

				@Override
				protected void onViewerUpdate() {
					setViewer(ScrumGwt.createToHtmlItemsWidget(release.getSprints()));
				}
			});
			tb.addFieldRow("Requirements", new AOutputViewEditWidget() {

				@Override
				protected void onViewerUpdate() {
					setViewer(ScrumGwt.createToHtmlItemsWidget(release.getRequirements()));
				}
			});
		}
		tb.addFieldRow("Affected by issues", new AOutputViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewer(ScrumGwt.createToHtmlItemsWidget(release.getAffectedByIssues()));
			}
		});
		tb.addFieldRow("Fixed issues", new AOutputViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewer(ScrumGwt.createToHtmlItemsWidget(release.getFixedIssues()));
			}
		});
		tb.addFieldRow("Planned issues", new AOutputViewEditWidget() {

			@Override
			protected void onViewerUpdate() {
				setViewer(ScrumGwt.createToHtmlItemsWidget(release.getPlannedIssues()));
			}
		});
		tb.addRow(new ChangeHistoryWidget(release), 2);

		return TableBuilder.row(20, tb.createTable(), ScrumGwt.createEmoticonsAndComments(release));
	}
}