package uw.cs.watform.forml.services.internal;

import javax.swing.JOptionPane;

import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.services.GUI.CustomMessageDialog;
import uw.cs.watform.forml.services.utilities.ModelUtils;

/**
 * All the message dialogs are declared in this class.
 * 
 * 
 * @author ppourali
 */
public class MessageDialogs {
	/**
	 * Deleting the feature will delete all the feature modules corresponding to
	 * this feature and its containing features. Are you sure?
	 * 
	 * @return dialog result
	 */
	public static int ConfirmDeleteAllContainingFeatureNodes() {
		return CustomMessageDialog.ShowQuestionDialog(
				"Deleting the feature will delete all the feature modules corresponding to this feature and its containing features. Are you sure?",
				JOptionPane.YES_NO_OPTION, new String[] { "Yes, Delete All!", "No, Cancel!" }, 1);
	}

	/**
	 * Are you sure to delete the representation and the corresponding feature
	 * in the model?
	 * 
	 * @return dialog result
	 */
	public static int ConfirmDeleteRepresentation() {
		return CustomMessageDialog.ShowQuestionDialog(
				"Are you sure to delete the representation and the corresponding feature in the model?",
				JOptionPane.YES_NO_OPTION, new String[] { "Yes, DELETE!", "No!" }, 1);
	}

	/**
	 * You cannot delete a feature model or feature/class diagram. Do you want
	 * to edit it instead?
	 * 
	 * @return dialog result
	 */
	public static int ConfirmEditWMDiagramInsteadOfDelete() {
		return CustomMessageDialog.ShowQuestionDialog(
				"You cannot delete a feature model or feature/class diagram. Do you want to edit it instead?",
				JOptionPane.YES_NO_OPTION, new String[] { "Yes!", "No!" }, 1);
	}

	/**
	 * Changing the message type will impact all the features containing this
	 * message. Are you sure?
	 * 
	 * @return dialog result
	 */
	public static int ConfirmChangeMessageTypeImpact() {
		return CustomMessageDialog.ShowQuestionDialog(
				"Changing the message type will impact all the features containing this message. Are you sure?",
				JOptionPane.YES_NO_CANCEL_OPTION, new String[] { "Yes, Update All!", "No, Only One!", "Cancel !" }, 0);
	}
	
	/**
	 * Acknowledging the the referrants will also be renamed.
	 * 
	 * @return void
	 */
	public static void DisplayChangeElementNameImpact() {
		JOptionPane.showMessageDialog(null, "The referring elements to the renamed element, if any, have also been updated to the new name.");
	}

	/**
	 * Rename can not be done. A Message with the name: "N" already exists, Do
	 * you want to merge with the existing message?
	 * 
	 * @return dialog result
	 */
	public static int ConfirmMergeMessagesIfAlreadyExist(String newName) {
		return CustomMessageDialog.ShowQuestionDialog(
				"Rename can not be done. A Message with the name: " + newName.trim()
						+ " already exists, Do you want to merge with the existing message?",
				JOptionPane.YES_NO_OPTION, new String[] { "Yes, Merge All!", "No, Cancel!", }, 1);
	}

	/**
	 * Changing the message name will impact all the features containing this
	 * message. Are you sure?
	 * 
	 * @return dialog result
	 */
	public static int ConfirmChangeMessageNameImpact(Message msg, int optionType) {
		// if there are multiple instances of the message in more than one
		// feature
		if (ModelUtils.getNumberOfUsesForMessage(msg) > 1) {
			int dialogResult = 0;
			if (optionType == JOptionPane.YES_NO_CANCEL_OPTION) {
				dialogResult = CustomMessageDialog.ShowQuestionDialog(
						"Changing the message name will impact all the features containing this message. Are you sure?",
						optionType, new String[] { "Yes, Update All!", "No, Only One!", "Cancel" }, 0);
			} else if (optionType == JOptionPane.YES_NO_OPTION) {
				dialogResult = CustomMessageDialog.ShowQuestionDialog(
						"Changing the message name will impact all the features containing this message. Are you sure?",
						optionType, new String[] { "Yes, Update All!", "No, Cancel!" }, 0);
			}

			return dialogResult;
		}
		// Assume default behaviour should be just as NO option
		return -1;
	}

	/**
	 * A Message with the name already exists, please enter a new name
	 * 
	 * @return dialog result
	 */
	public static String InputNewMessageName() {
		return JOptionPane.showInputDialog(null, "Enter the new name:");

	}

	/**
	 * Confirming if Auto set the triggering event
	 * 
	 * 
	 * @return dialog result
	 */
	public static int ConfirmAutoSetTrigEvent(String trigName) {
		return CustomMessageDialog.ShowQuestionDialog(
				"Do you want to set " + trigName.trim() + " as the triggering event?", JOptionPane.YES_NO_OPTION,
				new String[] { "Yes, Use it!", "No!" }, 1);
	}
}
