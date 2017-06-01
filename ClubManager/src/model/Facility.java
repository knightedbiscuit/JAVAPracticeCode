package model;

import java.io.Serializable;

public class Facility implements Serializable {

	private String name;
	private String description;
	
	public Facility(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Facility(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public void show()
	{
		System.out.println(toString());
	}
	
	public String toString()
	{
		if(description != null)
		{
			return (name + " ("+ description + ")");	
		}
		else
		{
			return (name);
		}
	}
	
	
}
