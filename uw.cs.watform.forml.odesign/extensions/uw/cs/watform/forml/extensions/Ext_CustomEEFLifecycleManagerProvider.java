package uw.cs.watform.forml.extensions;

import org.eclipse.eef.EEFControlDescription;
import org.eclipse.eef.EEFCustomWidgetDescription;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManager;
import org.eclipse.eef.ide.ui.api.widgets.IEEFLifecycleManagerProvider;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.ActionEditorLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.ClassPreviewerForFeatureModuleLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.ClassPreviewerForStateLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.ClassPreviewerForTransitionLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.CrossRefsEditorLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.EventEditorLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.FeatureTreePreviewerLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.GuardEditorLifecycleManager;
import uw.cs.watform.forml.extensions.EmbeddedLinkEditor.StateMachinePreviewerLifecycleManager;

public class Ext_CustomEEFLifecycleManagerProvider implements IEEFLifecycleManagerProvider {

	public Ext_CustomEEFLifecycleManagerProvider() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The identifier of the control description supported.
	 */
	private static final String SUPPORTED_ID1 = "uw.cs.watform.forml.ext.widgets.GuardEditor"; //$NON-NLS-1$
	private static final String SUPPORTED_ID2 = "uw.cs.watform.forml.ext.widgets.EventEditor"; //$NON-NLS-1$
	private static final String SUPPORTED_ID3 = "uw.cs.watform.forml.ext.widgets.ActionEditor"; //$NON-NLS-1$
	private static final String SUPPORTED_ID4 = "uw.cs.watform.forml.ext.widgets.lblSaveStatus";
	private static final String SUPPORTED_ID5 = "uw.cs.watform.forml.ext.widgets.CrossRefsViewer";
	private static final String SUPPORTED_ID6 = "uw.cs.watform.forml.ext.widgets.StateMachinePreviewer";
	private static final String SUPPORTED_ID7 = "uw.cs.watform.forml.ext.widgets.FeatureTreePreviewer";
	private static final String SUPPORTED_ID8 = "uw.cs.watform.forml.ext.widgets.ClassContainerForFeatureModule";
	private static final String SUPPORTED_ID9 = "uw.cs.watform.forml.ext.widgets.ClassContainerForState";
	private static final String SUPPORTED_ID10 = "uw.cs.watform.forml.ext.widgets.ClassContainerForTransition";

	@Override
	public boolean canHandle(EEFControlDescription controlDescription) {
		// only support custom widgets with the proper identifier
		// System.out.println(controlDescription.getIdentifier());
		return ((SUPPORTED_ID1.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID2.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID3.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID4.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID5.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID6.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID7.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID8.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID9.equals(controlDescription.getIdentifier())
				|| SUPPORTED_ID10.equals(controlDescription.getIdentifier()))
				&& controlDescription instanceof EEFCustomWidgetDescription);
	}

	@Override
	public IEEFLifecycleManager getLifecycleManager(EEFControlDescription controlDescription,
			IVariableManager variableManager, IInterpreter interpreter, EditingContextAdapter contextAdapter) {
		if (controlDescription instanceof EEFCustomWidgetDescription) {
			if (SUPPORTED_ID1.equals(controlDescription.getIdentifier())) {
				return new GuardEditorLifecycleManager((EEFCustomWidgetDescription) controlDescription, variableManager,
						interpreter, contextAdapter);
			} else if (SUPPORTED_ID2.equals(controlDescription.getIdentifier())) {
				return new EventEditorLifecycleManager((EEFCustomWidgetDescription) controlDescription, variableManager,
						interpreter, contextAdapter);
			} else if (SUPPORTED_ID3.equals(controlDescription.getIdentifier())) {
				return new ActionEditorLifecycleManager((EEFCustomWidgetDescription) controlDescription,
						variableManager, interpreter, contextAdapter);
			} else if (SUPPORTED_ID4.equals(controlDescription.getIdentifier())) {
				return new LblSaveStatusEditorLifecycleManager((EEFCustomWidgetDescription) controlDescription,
						variableManager, interpreter, contextAdapter);
			} else if (SUPPORTED_ID5.equals(controlDescription.getIdentifier())) {
				return new CrossRefsEditorLifecycleManager((EEFCustomWidgetDescription) controlDescription,
						variableManager, interpreter, contextAdapter);
			} else if (SUPPORTED_ID6.equals(controlDescription.getIdentifier())) {
				return new StateMachinePreviewerLifecycleManager((EEFCustomWidgetDescription) controlDescription,
						variableManager, interpreter, contextAdapter);
			} else if (SUPPORTED_ID7.equals(controlDescription.getIdentifier())) {
				return new FeatureTreePreviewerLifecycleManager((EEFCustomWidgetDescription) controlDescription,
						variableManager, interpreter, contextAdapter);
			} else if (SUPPORTED_ID8.equals(controlDescription.getIdentifier())) {
				return new ClassPreviewerForFeatureModuleLifecycleManager(
						(EEFCustomWidgetDescription) controlDescription, variableManager, interpreter, contextAdapter);
			} else if (SUPPORTED_ID9.equals(controlDescription.getIdentifier())) {
				return new ClassPreviewerForStateLifecycleManager((EEFCustomWidgetDescription) controlDescription,
						variableManager, interpreter, contextAdapter);
			} else if (SUPPORTED_ID10.equals(controlDescription.getIdentifier())) {
				return new ClassPreviewerForTransitionLifecycleManager((EEFCustomWidgetDescription) controlDescription,
						variableManager, interpreter, contextAdapter);
			}
		}
		throw new IllegalArgumentException();
	}

}
