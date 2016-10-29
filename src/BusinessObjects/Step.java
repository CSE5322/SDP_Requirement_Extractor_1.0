package BusinessObjects;

import java.util.ArrayList;

public class Step extends RequirementComponent
{
	//BusinessProcess parent;
	
	private ArrayList<Action> actionsList;
	
	public ArrayList<Action> getActionsList() {
		return actionsList;
	}

	public void setActionsList(ArrayList<Action> actionsList) {
		this.actionsList = actionsList;
	}

	public Step(Phrase ph)
	{
		super(ph);
		
		actionsList = new ArrayList<Action>();
	}
	

}
