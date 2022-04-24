package Utils;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.Scenario;


public class ScenarioContext {
	private Scenario scenario;
	private Map<String, Object> contextData;
	
	public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

	public Map<String, Object> getContextData() {
		return contextData;
	}

	public void setContextData(Map<String, Object> contextData) {
		this.contextData = contextData;
	}

    public void clearContextData() {
    	this.contextData = new HashMap<>();
    }
}
