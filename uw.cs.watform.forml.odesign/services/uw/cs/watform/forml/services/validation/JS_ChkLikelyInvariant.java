package uw.cs.watform.forml.services.validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import uw.cs.watform.forml.forml.Feature;
import uw.cs.watform.forml.forml.Message;
import uw.cs.watform.forml.forml.RefMessage;
import uw.cs.watform.forml.services.utilities.ModelUtils;

public class JS_ChkLikelyInvariant {

	static EObject wm;

	private static double T_SUPPORT = 3, T_CONFIDENCE = 0.65;


	// A HashMap to keep track of: for each function f, which scopes are calling f
	private static HashMap<Integer, HashSet<Integer>> map_Func_Scopes = new HashMap<Integer, HashSet<Integer>>();

	// A HashMap to keep track of: for each scope s, which functions are being called in s
	private static HashMap<Integer, HashSet<Integer>> map_Scope_Funcs = new HashMap<Integer, HashSet<Integer>>();

	// A HashMap to keep the information to reverse hash values to their original string format (deHash !) 
	private static HashMap<Integer, String> map_reverseHash = new HashMap<Integer, String>();

	// A HashSet to keep the information of the false positive scopes 
	//private static HashSet<Integer> okScopes=new HashSet<Integer>();


	public static void checkLikelyInvariants(EObject t) {

		wm=t;

		map_Func_Scopes.clear();
		map_Scope_Funcs.clear();
		map_reverseHash.clear();

		T_SUPPORT = 3;
		T_CONFIDENCE = 65;


		/* 
		 * The following is the main steps of the whole approach 
		 */


		// 2. Read from the call graph to retrieve the 
		// information regarding the scopes and functions
		// in other words, it creates a hash table to keep track of 
		//which scopes call which functions (i.e. (Scopes, {functions}) 
		create_map_Scopes_Call_Functions();


		// 3. Create a hash table to keep track of which scopes 
		//is being called by which function(i.e. (function, {Scopes}) 
		create_map_Functions_Called_By_Scopes();


		// 4. Analyze the information retrieved from Step 3,
		// and find the pair bugs 
		findPairBugs();

	}

	/**
	 * In this function, we find the bugs based on the following algorithm:<br><br>
	 * 1- We make pairs with by covering all the combinations of existing function,<br>
	 *    for example if there are a set functions {A,B,C},<br>
	 *    then the list of pairs will be: <br>
	 *    for A -> {A,B}, {A,C}<br>
	 *    for B -> {B,A}, {B,C}<br>
	 *    for C -> {C,A}, {C,B}<br>
	 *    Note that a function cannot make a pair with itself e.g. {A, A}
	 * <br> <br>
	 * 2- For each function in the pair, we find a set of scopes that are calling the function,
	 *    for example, for pair {A, B}, we find a set of scopes calling A, and a set of scopes calling B
	 * <br><br>
	 * 3- We find the difference of the two sets for the two functions in the pair, <br>
	 *    and then by checking the support and confidence, we can see if it is a bug!   
	 */
	private static void findPairBugs() {


		// from the list of functions, pick one at a time and name it func1
		for (Integer func1 : map_Func_Scopes.keySet()) {

			// find the support for the function
			int support = map_Func_Scopes.get(func1).size();

			// check if the support is not less than the input threshold for support
			if (support >= T_SUPPORT) {

				// from the list of functions, pick one at a time and name it func 2
				for (Integer func2 : map_Func_Scopes.keySet()) {

					// make sure we are not going to pair with the same function e.g. {A, A}
					if (!func1.equals(func2)) {

						// find the calling scopes for func1 and func2 and find their intersection
						HashSet<Integer> intersection = new HashSet<Integer>(
								map_Func_Scopes.get(func1));
						intersection.retainAll(map_Func_Scopes.get(func2));

						// if there are some scopes that are calling both func1 and func2,
						// check that they are calling more than support
						if (intersection.size() >= T_SUPPORT) {

							// if support condition passes, find the confidence
							double confidence = 100
									* ((double) intersection.size())/((double) map_Func_Scopes.get(func1).size());

							// checks if confidence {func1, func2} passes the threshold 
							if (confidence >= T_CONFIDENCE && confidence < 100) {

								// find the difference of the calling scopes of the two functions,
								// e.g. {callingScope (func1)} - {callingScope (func2)}
								// each element in the {difference}, represents the potential buggy scopes
								HashSet<Integer> buggyScopes = new HashSet<Integer>(
										map_Func_Scopes.get(func1));
								buggyScopes.removeAll(intersection);

								// check if there are any scopes containing the buggy pair
								if(buggyScopes.size()>0){

									// print buggy scopes, we pass the whole difference SET, 
									// and it will print all of the elements in the set
									printBug(map_reverseHash.get(func1),buggyScopes, map_reverseHash.get(func1), map_reverseHash.get(func2),
											intersection.size(),confidence);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * A method to print out the bugs that are found! 
	 * @param buggyFunction
	 * @param buggyScopes
	 * @param funcOne
	 * @param funcTwo
	 * @param support
	 * @param confidence
	 */
	private static void printBug(String buggyFunction, HashSet<Integer> buggyScopes, String firstFuncInPair, String secondFuncInPair, int support, double confidence)
	{
		 System.out.flush();  
		 
		// sort the functions in pair .e.g {A, B} instead of {B, A}
		if (firstFuncInPair.compareTo (secondFuncInPair) >0 )
		{
			String temp = firstFuncInPair;
			firstFuncInPair = secondFuncInPair;
			secondFuncInPair=temp;
		}

		// print the elements in the buggy scopes one by one
		for (Integer elemInSetsDiff : buggyScopes) {
			System.out.printf("Warning: %s in %s is missing its pair: (%s, %s), support: %d, confidence: %.2f%%%n",
					buggyFunction,	map_reverseHash.get(elemInSetsDiff),firstFuncInPair, secondFuncInPair,support,confidence);

		}
	}


	/**
	 * It reads the call graph and stores the needed valuable information
	 * <br>it stores a list of scopes that are calling a particular function
	 * <br>e.g. for A={Scope1, Scope2, Scope3} 
	 */
	private static void create_map_Scopes_Call_Functions() {

		try {

			// find all the features in the world model
			List<Feature> features=ModelUtils.getWorldModelObjectsByType(wm, Feature.class);

			String scopeName = null;

			for(EObject f:features) {

				scopeName = ((Feature)f).getName();
				if(((Feature)f).getInputlist()!=null)
				{
					for(RefMessage m:((Feature)f).getInputlist().getInputs())
					{
						String msgName = m.getRefMsg().getName();

						// add the message to the list of message that are being called by the scope feature
						if (map_Scope_Funcs.get(hashfunc(scopeName)) == null) {
							HashSet<Integer> temp = new HashSet<Integer>();
							int functionHashCode = hashfunc(msgName);
							temp.add(functionHashCode);
							map_Scope_Funcs.put(hashfunc(scopeName), temp);
						} else {
							map_Scope_Funcs.get(hashfunc(scopeName)).add(
									hashfunc(msgName));
						}
					}
				}

				if(((Feature)f).getOutputlist()!=null)
				{
					for(RefMessage m:((Feature)f).getOutputlist().getOutputs())
					{
						String msgName = m.getRefMsg().getName();

						// add the message to the list of message that are being called by the scope feature
						if (map_Scope_Funcs.get(hashfunc(scopeName)) == null) {
							HashSet<Integer> temp = new HashSet<Integer>();
							int functionHashCode = hashfunc(msgName);
							temp.add(functionHashCode);
							map_Scope_Funcs.put(hashfunc(scopeName), temp);
						} else {
							map_Scope_Funcs.get(hashfunc(scopeName)).add(
									hashfunc(msgName));
						}
					}
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a hash table to keep track of which function </br>
	 * is being called by which scope (i.e. (function, {Scopes}) 
	 */
	private static void create_map_Functions_Called_By_Scopes()
	{

		// read from the map_Scope_Funcs and create map_Func_Scopes
		for(Integer scopeName : map_Scope_Funcs.keySet()){

			// get the functions that the scope<scopeName> calls
			HashSet<Integer> functions = map_Scope_Funcs.get(scopeName);

			// add the mapping from functions to scope
			for(Integer funcName: functions)
			{
				// add the scope to the list of scopes that are calling the function
				if (map_Func_Scopes.get(funcName) == null) {
					HashSet<Integer> temp = new HashSet<Integer>();
					temp.add(scopeName);
					map_Func_Scopes.put(funcName, temp);
				} else {
					map_Func_Scopes.get(funcName).add(
							scopeName);
				}
			}
		}

	}

	/**
	 * A customized hash function to return the hash code of a given string
	 * @param key
	 * @return
	 */
	static final int hashfunc(String key) {
		int h;
		if (key == null)
			return 0;
		else {
			h = key.hashCode();

			// keep the track of the string and its hash code, so that you can reverse it later
			map_reverseHash.put(h, key);

			return (h);
		}
	}
}