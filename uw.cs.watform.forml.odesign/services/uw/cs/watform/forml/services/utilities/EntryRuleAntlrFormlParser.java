package uw.cs.watform.forml.services.utilities;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import uw.cs.watform.forml.parser.antlr.FormlParser;
/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EntryRuleAntlrFormlParser extends FormlParser implements IParserConstants {

	@Inject(optional = true)
	@Named(ENTRY_RULE)
	private String entryRule;

	@Override
	protected String getDefaultRuleName() {
		return entryRule != null ? entryRule : super.getDefaultRuleName();
	}

}