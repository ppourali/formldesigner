package uw.cs.watform.forml.formatting;

import javax.swing.JOptionPane;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;

import uw.cs.watform.forml.services.FormlGrammarAccess;

public class customFormlFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
/*
		FormlGrammarAccess f = (FormlGrammarAccess)getGrammarAccess();
//
		  // set a line wrap before each feature rule 
		  c.setLinewrap().before(f.getFeatureRule());
		  // set a line wrap after each feature rule 
		  c.setLinewrap().after(f.getFeatureRule());

		  // set a line wrap before each predicate and macro rules 
		  //c.setLinewrap().before(f.getPredicateRule());
		  c.setLinewrap().before(f.getMacroRule());
		  // set a line wrap after each predicate and macro rules 
		 // c.setLinewrap().after(f.getPredicateRule());
		  c.setLinewrap().after(f.getMacroRule());

		  // set a line wrap before each Behaviour rule 
		  c.setLinewrap(2).before(f.getBehaviourModelRule());
		  // set a line wrap after each Behaviour rule 
		  c.setLinewrap().after(f.getBehaviourModelRule());

		  
		  // set a line wrap before each transition rule 
		  c.setLinewrap().before(f.getTransitionRule());
		  // set a line wrap after each transition rule 
		  c.setLinewrap().after(f.getTransitionRule());
*/
	}

}
