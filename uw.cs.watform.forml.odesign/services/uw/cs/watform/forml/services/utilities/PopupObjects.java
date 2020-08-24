package uw.cs.watform.forml.services.utilities;

import java.util.ArrayList;
import java.util.List;

public class PopupObjects {

	private String name="";
	
	private List<PopupObjects> fields=new ArrayList<PopupObjects>();
	
	private String returnType="";

	public List<PopupObjects> getFields() {
		return fields;
	}
	
	public PopupObjects(String ObjectName, String ObjectType)
	{
		setName(ObjectName);
		setReturnType(ObjectType);
	}
	
	public PopupObjects(String ObjectName)
	{
		setName(ObjectName);
	}

	public void clear()
	{
		this.fields.clear();
	}
	
	public boolean isEmpty()
	{
		return this.fields.isEmpty();
	}
	
	public void addAllFields(List<PopupObjects> fields) {
		this.fields.addAll(fields);
	}
	
	public void addField(PopupObjects field) {
		this.fields.add(field);
	}

	public String getName() {
		return name;
	}

	
//	public String getFields(String name) {
//	
//		
//		
//		fields
//		return name;
//	}
		
	public void setName(String name) {
		this.name = name;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	
}
