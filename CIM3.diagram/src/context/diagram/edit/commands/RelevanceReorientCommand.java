package context.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import context.ContextElement;
import context.ContextModel;
import context.Focus;
import context.Relevance;
import context.diagram.edit.policies.CIM3BaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class RelevanceReorientCommand extends EditElementCommand {

	/**
	* @generated
	*/
	private final int reorientDirection;

	/**
	* @generated
	*/
	private final EObject oldEnd;

	/**
	* @generated
	*/
	private final EObject newEnd;

	/**
	* @generated
	*/
	public RelevanceReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	* @generated
	*/
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Relevance) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof ContextElement && newEnd instanceof ContextElement)) {
			return false;
		}
		if (getLink().getFocus().size() != 1) {
			return false;
		}
		Focus target = (Focus) getLink().getFocus().get(0);
		if (!(getLink().eContainer() instanceof ContextModel)) {
			return false;
		}
		ContextModel container = (ContextModel) getLink().eContainer();
		return CIM3BaseItemSemanticEditPolicy.getLinkConstraints().canExistRelevance_4015(container, getLink(),
				getNewSource(), target);
	}

	/**
	* @generated
	*/
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Focus && newEnd instanceof Focus)) {
			return false;
		}
		if (getLink().getRelevantContext().size() != 1) {
			return false;
		}
		ContextElement source = (ContextElement) getLink().getRelevantContext().get(0);
		if (!(getLink().eContainer() instanceof ContextModel)) {
			return false;
		}
		ContextModel container = (ContextModel) getLink().eContainer();
		return CIM3BaseItemSemanticEditPolicy.getLinkConstraints().canExistRelevance_4015(container, getLink(), source,
				getNewTarget());
	}

	/**
	* @generated
	*/
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	* @generated
	*/
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().getRelevantContext().remove(getOldSource());
		getLink().getRelevantContext().add(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getFocus().remove(getOldTarget());
		getLink().getFocus().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	* @generated
	*/
	protected Relevance getLink() {
		return (Relevance) getElementToEdit();
	}

	/**
	* @generated
	*/
	protected ContextElement getOldSource() {
		return (ContextElement) oldEnd;
	}

	/**
	* @generated
	*/
	protected ContextElement getNewSource() {
		return (ContextElement) newEnd;
	}

	/**
	* @generated
	*/
	protected Focus getOldTarget() {
		return (Focus) oldEnd;
	}

	/**
	* @generated
	*/
	protected Focus getNewTarget() {
		return (Focus) newEnd;
	}
}
