package Commands;

import BusinessObjects.Action;
import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.RequirementComponent;
import BusinessObjects.Step;

public class RemoveComponent {
	
	Object parent;
	RequirementComponent child;
	public RemoveComponent(Object parent,RequirementComponent child) {
		this.parent=parent;
		this.child=child;
	}
	
	
	public boolean execute()
	{
		if(parent instanceof Repository )
		{
			//hello
			 //return ((Repository) parent).getBusinessProcessList().add((BusinessProcess) child);
		}
		else if(parent instanceof BusinessProcess)
		{
			//return ((BusinessProcess)parent).getStepsList().add((Step) child);
			 //((BusinessProcess)parent).ggetadd((Step) child);
		}
		else if(parent instanceof Step)
		{
			//return ((Step)parent).getActionsList().add((Action) child);
		}
			
		return false;
	}

}
