package scrum.server.sprint;

import ilarkesto.pdf.ACell;
import ilarkesto.pdf.AParagraph;
import ilarkesto.pdf.APdfContainerElement;
import ilarkesto.pdf.ARow;
import ilarkesto.pdf.ATable;
import ilarkesto.pdf.FieldList;
import ilarkesto.pdf.FontStyle;

import java.awt.Color;
import java.util.List;

import scrum.server.common.APdfCreator;
import scrum.server.common.BurndownChart;
import scrum.server.common.ScrumPdfContext;
import scrum.server.common.WikiToPdfConverter;
import scrum.server.sprint.SprintReportHelper.StoryInfo;
import scrum.server.sprint.SprintReportHelper.TaskInfo;

public class SprintReportPdfCreator extends APdfCreator {

	private Sprint sprint;

	public SprintReportPdfCreator(Sprint sprint) {
		super();
		this.sprint = sprint;
	}

	@Override
	protected void build(APdfContainerElement pdf) {
		reportHeader(pdf, "Sprint Report", sprint.getProject().getLabel());

		pdf.nl();
		FieldList fields = pdf.fieldList().setLabelFontStyle(fieldLabelFont);
		fields.field("Sprint").text(sprint.getLabel());
		fields.field("Period").text(
			sprint.getBegin() + " - " + sprint.getEnd() + " / " + sprint.getLengthInDays() + " days");
		fields.field("Velocity").text(sprint.getVelocity() + " StoryPoints");
		fields.field("Product Owner").text(sprint.getProductOwnersAsString());
		fields.field("Scrum Master").text(sprint.getScrumMastersAsString());
		fields.field("Team").text(sprint.getTeamMembersAsString());

		pdf.nl();
		pdf.image(BurndownChart.createBurndownChartAsByteArray(sprint, 1000, 500)).setScaleByWidth(150f);

		if (sprint.isGoalSet()) {
			sectionHeader(pdf, "Goal");
			WikiToPdfConverter.buildPdf(pdf, sprint.getGoal(), new ScrumPdfContext());
		}

		if (sprint.isCompletedRequirementLabelsSet()) {
			sectionHeader(pdf, "Completed stories");
			WikiToPdfConverter.buildPdf(pdf, sprint.getCompletedRequirementLabels(), new ScrumPdfContext());
		}

		requirements(pdf, "Completed stories", sprint.getCompletedRequirementsData());
		requirements(pdf, "Rejected stories", sprint.getIncompletedRequirementsData());

		if (sprint.isReviewNoteSet()) {
			sectionHeader(pdf, "Review notes");
			WikiToPdfConverter.buildPdf(pdf, sprint.getReviewNote(), new ScrumPdfContext());
		}

		if (sprint.isRetrospectiveNoteSet()) {
			sectionHeader(pdf, "Retrospecitve notes");
			WikiToPdfConverter.buildPdf(pdf, sprint.getRetrospectiveNote(), new ScrumPdfContext());
		}

	}

	private void requirements(APdfContainerElement pdf, String title, String requirementsData) {
		List<StoryInfo> requirements = SprintReportHelper.parseRequirementsAndTasks(requirementsData);
		if (requirements.isEmpty()) return;
		sectionHeader(pdf, title);
		for (StoryInfo req : requirements) {
			requirement(pdf, req);
		}
	}

	private void requirement(APdfContainerElement pdf, StoryInfo req) {
		pdf.nl();

		ATable table = pdf.table(3, 20, 2, 2);

		ARow rowHeader = table.row().setDefaultBackgroundColor(Color.LIGHT_GRAY);
		rowHeader.cell().setFontStyle(referenceFont).text(req.getReference());
		rowHeader.cell().setFontStyle(new FontStyle(defaultFont).setBold(true)).text(req.getLabel());
		rowHeader.cell().paragraph().text(req.getEstimatedWorkAsString(), referenceFont);
		rowHeader.cell().paragraph().text(req.getBurnedWorkAsString(), referenceFont);

		List<TaskInfo> tasks = req.getTasks();
		for (TaskInfo tsk : tasks) {
			ACell tasksCell = table.row().cell().setColspan(table.getColumnCount());
			AParagraph p = tasksCell.paragraph();
			p.text(tsk.getReference(), referenceFont);
			p.text(" " + tsk.getLabel() + " ", defaultFont);
			p.text(tsk.getBurnedWork() + " hrs.", referenceFont);
		}

		table.createCellBorders(Color.GRAY, 0.2f);
	}

	private void sectionHeader(APdfContainerElement pdf, String label) {
		pdf.paragraph().nl().text(label, headerFonts[1]).nl();
	}

	@Override
	protected String getFilename() {
		return "sprint";
	}

}
