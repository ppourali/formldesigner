package uw.cs.watform.forml.services.GUI.FeatureModuleFocusContextViewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import uw.cs.watform.forml.extensions.LblSaveStatusEditorLifecycleManager;
import uw.cs.watform.forml.forml.Attribute;
import uw.cs.watform.forml.forml.Entity;
import uw.cs.watform.forml.forml.ExprRef;
import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.Function;
import uw.cs.watform.forml.forml.Guard;
import uw.cs.watform.forml.forml.InputList;
import uw.cs.watform.forml.forml.OutputList;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.forml.Roleable;
import uw.cs.watform.forml.forml.Trigger;
import uw.cs.watform.forml.forml.WCAList;
import uw.cs.watform.forml.services.GUI.TransitionDialogBox.NewElementCreation.CreateElementDialog;
import uw.cs.watform.forml.services.utilities.ModelUtils;
import org.eclipse.swt.widgets.Label;

public class CustomSearchBarForFeatureModuleClassPreviewer extends Composite {

	private Text textSearch;
	private Label lblResult;
	private String splitChar = ".";
	private String splitCharForEntityType = "::";
	// private Button btnCreate;
	private HashMap<String, List<EObject>> map_Names_Element = new HashMap<String, List<EObject>>();

	/**
	 * A String for key press
	 */
	private String KEY_PRESS = "Ctrl+Space";
	private Roleable currentRoleable;
	private AbstractCustomCompositeForClassViewer customCompositeClassViewer;

	static ContentProposalAdapter adapter = null;

	public CustomSearchBarForFeatureModuleClassPreviewer(Composite parent, int style, Roleable roleable,
			AbstractCustomCompositeForClassViewer customCompositeForClassViewer) {
		super(parent, style);
		this.currentRoleable = roleable;
		this.customCompositeClassViewer = customCompositeForClassViewer;
		ConstructDesign();

		createMap();
	}

	private String getElementActualName(String proposalString) {
		String elementNameTemp = StringUtils.substringAfterLast(proposalString, splitChar);
		String elementName = StringUtils.substringBefore(elementNameTemp, splitCharForEntityType);
		return elementName.trim();
	}

	/**
	 * Method used to display an array of String data for autocompletion. You can
	 * have your own method like this to get the autocompletion data. This method
	 * can be customized to get the data from database and you can display as
	 * autocompletion array.
	 *
	 * @param text of type String
	 * @return an array of String data
	 * @author Debadatta Mishra (PIKU)
	 */
	private String[] getAllProposals(String text) {

		// if (map_Names_Element.isEmpty())
		createMap();

		Set<String> defaultProposals = map_Names_Element.keySet();

		String[] resultsArray;

		boolean shouldCreate = false;
		if (!text.trim().equals("")) {
			java.util.List<String> props = new ArrayList<String>();

			for (String s : defaultProposals) {
				String elementName = getElementActualName(s);
				if (elementName.toLowerCase().equals(text.toLowerCase().trim())) {
					props.add(s);
					shouldCreate = false;
				} else if (s.toLowerCase().contains(text.toLowerCase().trim())) {
					props.add(s);
					shouldCreate = true;
				}
			}
			if (shouldCreate) {
				// props.add(0, "Create Element: " + text);
			}
			resultsArray = props.toArray(new String[props.size()]);

		} else {
			resultsArray = defaultProposals.toArray(new String[defaultProposals.size()]);
		}

		if (resultsArray.length == 0) {

			resultsArray = findSimilars(text);

		}

		return resultsArray;
	}

	private String[] findSimilars(String text) {
		Set<String> defaultProposals = map_Names_Element.keySet();

		String[] similarArray;

		java.util.List<String> props = new ArrayList<String>();
		// props.add("Create Element: " + text);
		for (String s : defaultProposals) {
			java.util.List<String> propsDist0 = new ArrayList<String>();
			java.util.List<String> propsDist1 = new ArrayList<String>();
			java.util.List<String> propsDist2 = new ArrayList<String>();
			java.util.List<String> propsDist3 = new ArrayList<String>();
			java.util.List<String> propsDist4 = new ArrayList<String>();
			int dist = calculateLevenshteinDistance(s.toLowerCase(), text.toLowerCase());
			// System.out.println(s + text + dist);
			if (dist == 0) {
				propsDist0.add(s);
			} else if (dist == 1) {
				propsDist1.add(s);
			} else if (dist == 2) {
				propsDist2.add(s);
			} else if (dist == 3) {
				propsDist3.add(s);
			} else if (dist == 4) {
				propsDist4.add(s);
			}

			props.addAll(propsDist0);
			props.addAll(propsDist1);
			props.addAll(propsDist2);
			props.addAll(propsDist3);
			props.addAll(propsDist4);
		}

		similarArray = props.toArray(new String[props.size()]);

		return similarArray;
	}

	private void setAutoCompletion(Text text, String value) {
		try {

			SimpleContentProposalProvider scp = new SimpleContentProposalProvider();

			KeyStroke ks = KeyStroke.getInstance(KEY_PRESS);
			adapter = new ContentProposalAdapter(text, new TextContentAdapter(), scp, ks, null);
			adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
			adapter.addContentProposalListener(new IContentProposalListener() {

				@Override
				public void proposalAccepted(IContentProposal arg0) {
					if (arg0.getContent().startsWith("Create Element: ")) {
						// ShowCreateDialog();
					}
				}
			});
			setActivationChars();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void createMap() {
		map_Names_Element.clear();
		List<Feature> features = ModelUtils.getWorldModelObjectsByType(this.currentRoleable, Feature.class);

		for (Feature f : features) {

			addToMap(f, f);

			EList<ExprRef> atts = f.getAttributes();
			for (ExprRef atr : atts) {
				addToMap(f, atr);
			}

			InputList inputs = f.getInputlist();
			if (inputs != null) {
				for (RefMessage in : inputs.getInputs()) {
					addToMap(f, in);
				}
			}

			OutputList outputs = f.getOutputlist();
			if (outputs != null) {
				for (RefMessage out : outputs.getOutputs()) {
					addToMap(f, out);
				}
			}

		}

		List<Entity> entities = ModelUtils.getWorldModelObjectsByType(this.currentRoleable, Entity.class);

		for (Entity e : entities) {

			addToMap(e, e);

			EList<ExprRef> atts = e.getAttributes();
			for (ExprRef atr : atts) {
				addToMap(e, atr);
			}

			EList<ExprRef> funcs = e.getFunctions();
			if (funcs != null) {
				for (ExprRef fu : funcs) {
					addToMap(e, fu);
				}
			}
		}
	}

	private void addToMap(Roleable f, EObject element) {
		String name = "";
		if (element instanceof Feature) {
			name = f.getName() + " :: Feature";
		} else if (element instanceof Entity) {
			name = f.getName() + " :: Class";
		} else if (element instanceof Attribute) {
			name = f.getName() + splitChar + ((Attribute) element).getName() + " :: Attribute";
			;
		} else if (element instanceof RefMessage) {
			name = f.getName() + splitChar + ((RefMessage) element).getRefMsg().getName() + " :: Message";
			;
		} else if (element instanceof Function) {
			name = f.getName() + splitChar + ((Function) element).getName() + " :: Function";
			;
		}

		if (name != "") {

			if (map_Names_Element.containsKey(name)) {
				List<EObject> elements = map_Names_Element.get(name);
				elements.add(element);
				map_Names_Element.put(name, elements);
			} else {

				List<EObject> elements = new ArrayList<EObject>();
				elements.add(element);
				map_Names_Element.put(name, elements);
			}
		}

	}

	private void ConstructDesign() {
		setBounds(5, 0, 760, 60);
		setLayout(new GridLayout(3, false));

		CLabel lblSearchForElement = new CLabel(this, SWT.NO_BACKGROUND | SWT.LEFT);
		lblSearchForElement.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblSearchForElement.setText("Search for Element");

		textSearch = new Text(this, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 276;
		textSearch.setLayoutData(gd_text);
		textSearch.setBackground(SWTResourceManager.getColor(240, 255, 255));

		// btnCreate = new Button(this, SWT.NO_BACKGROUND);
		// btnCreate.setEnabled(false);
		// GridData gd_btnCreate = new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
		// 1);
		// gd_btnCreate.widthHint = 96;
		// btnCreate.setLayoutData(gd_btnCreate);
		// btnCreate.setText("Create");

		textSearch.addModifyListener(textModified());
		textSearch.addKeyListener(KeyListener());
		setAutoCompletion(textSearch, null);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);

		lblResult = new Label(this, SWT.NONE);
		GridData gd_lblResult = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_lblResult.heightHint = 30;
		lblResult.setLayoutData(gd_lblResult);
		lblResult.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		new Label(this, SWT.NONE);
	}

	private KeyListener KeyListener() {
		// TODO Auto-generated method stub
		return new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.KEYPAD_CR || e.keyCode == SWT.CR)
					ViewAndHighlightInUI(textSearch.getText());

			}
		};
	}

	private ModifyListener textModified() {
		return new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// searchForElement(textSearch.getText());
				filterContentAssist();
				lblResult.setText("");
			}
		};
	}

	protected void filterContentAssist() {
		String[] defaultProposals = getAllProposals(textSearch.getText().trim());
		SimpleContentProposalProvider scp = new SimpleContentProposalProvider(defaultProposals);
		adapter.setContentProposalProvider(scp);

	}

	private void setActivationChars() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String digits = "1234567890";
		String specialCharachters = ".-_";

		char[] activationChars = ArrayUtils.addAll(alphabet.toCharArray(), alphabet.toUpperCase().toCharArray());

		activationChars = ArrayUtils.addAll(activationChars, digits.toCharArray());

		activationChars = ArrayUtils.addAll(activationChars, specialCharachters.toCharArray());

		adapter.setAutoActivationCharacters(activationChars);

	}

	/*
	 * protected void searchForElement(String searchname) { String justName =
	 * CommonSpaceForContextualUI.getCurrentFeatureOrEntityClass().getName() + "." +
	 * StringUtils.substringAfterLast(searchname, ".");
	 * 
	 * List<EObject> elements = map_Names_Element.get(name); if (elements == null ||
	 * elements.isEmpty()) { btnCreate.setEnabled(true); } else {
	 * btnCreate.setEnabled(false); } }
	 */
	private void ViewAndHighlightInUI(String name) {
		List<EObject> elements = map_Names_Element.get(name);
		if (elements == null || elements.isEmpty()) {
			lblResult.setText("The element could not be found.");
			return;
		} else {

			EObject ele = elements.get(0);
			boolean result = this.customCompositeClassViewer.findItem(ele);
			if (!result)
				lblResult.setText("The element could not be found.");
			else
				lblResult.setText("The element is found.");
			// btnCreate.setEnabled(false);
		}

	}

	private int calculateLevenshteinDistance(String proposalString, String searchTextBox) {

		String elementName = getElementActualName(proposalString);
		return StringUtils.getLevenshteinDistance(elementName, searchTextBox);
		/*
		 * int[][] dp = new int[elementName.length() + 1][searchTextBox.length() + 1];
		 * 
		 * for (int i = 0; i <= proposalText.length(); i++) { for (int j = 0; j <=
		 * searchTextBox.length(); j++) { if (i == 0) { dp[i][j] = j; } else if (j == 0)
		 * { dp[i][j] = i; } else { dp[i][j] = min( dp[i - 1][j - 1] +
		 * costOfSubstitution(proposalText.charAt(i - 1), searchTextBox.charAt(j - 1)),
		 * dp[i - 1][j] + 1, dp[i][j - 1] + 1); } } }
		 * 
		 * return dp[proposalText.length()][searchTextBox.length()];
		 */
	}

	private int costOfSubstitution(char a, char b) {
		return a == b ? 0 : 1;
	}

	private int min(int... numbers) {
		return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
	}

}
