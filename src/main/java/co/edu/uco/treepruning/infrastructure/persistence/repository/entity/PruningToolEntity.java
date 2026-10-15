package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class PruningToolEntity {
	private UUID id;
	private PruningEntity pruning;
	private ToolEntity tool;

	public PruningToolEntity() {
		super();
		setId(UUIDHelper.getDefault());
		setPruning(new PruningEntity());
		setTool(new ToolEntity());
	}

	public PruningToolEntity(final UUID id) {
		super();
		setId(id);
		setPruning(new PruningEntity());
		setTool(new ToolEntity());
	}

	public PruningToolEntity(final UUID id, final PruningEntity pruning, final ToolEntity tool) {
		super();
		setId(id);
		setPruning(pruning);
		setTool(tool);
	}

	public UUID getId() {
		return id;
	}

	public PruningEntity getPruning() {
		return pruning;
	}
	public ToolEntity getTool() {
		return tool;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id);
	}
	public void setPruning(final PruningEntity pruning) {
		this.pruning = ObjectHelper.getDefault(pruning, new PruningEntity());
	}
	public void setTool(final ToolEntity tool) {
		this.tool = ObjectHelper.getDefault(tool, new ToolEntity());
	}

}
