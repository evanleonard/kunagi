package scrum.client.files;

import scrum.client.common.AScrumWidget;
import scrum.client.common.BlockListWidget;
import scrum.client.workspace.PagePanel;

import com.google.gwt.user.client.ui.Widget;

public class FileRepositoryWidget extends AScrumWidget {

	public BlockListWidget<File> list;

	@Override
	protected Widget onInitialization() {
		cm.getApp().callRequestImpediments();

		list = new BlockListWidget<File>(FileBlock.FACTORY);

		PagePanel page = new PagePanel();
		page.addHeader("File Repository");
		page.addSection(list);
		return page;
	}

	@Override
	protected void onUpdate() {
		super.onUpdate();
		list.setObjects(getCurrentProject().getFiles());
	}

	public void showFile(File file) {
		list.extendObject(file);
	}

	public void select(File file) {
		list.extendObject(file);
	}
}