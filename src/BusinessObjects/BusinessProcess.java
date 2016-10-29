package BusinessObjects;

import java.util.ArrayList;

public class BusinessProcess extends RequirementComponent
{
	private ArrayList<Step> stepsList;
	
	public BusinessProcess(Phrase phrase)
	{
		super(phrase);
		
		stepsList = new ArrayList<Step>();
	}
	
	public ArrayList<Step> getStepsList() {
		return stepsList;
	}

	public void setStepsList(ArrayList<Step> stepsList) {
		this.stepsList = stepsList;
	}
	
	 

	
	


}
