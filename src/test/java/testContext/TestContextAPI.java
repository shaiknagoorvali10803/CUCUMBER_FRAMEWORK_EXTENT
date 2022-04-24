package testContext;

import cucumber.api.Scenario;

public class TestContextAPI {
	
	 protected Scenario scn=null;
	 protected String name;
	public Scenario getScn() {
		return scn;
	}
	public void setScn(Scenario scn) {
		this.scn = scn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
    
}
