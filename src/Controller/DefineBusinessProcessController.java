package Controller;

import java.util.List;

import BusinessObjects.BusinessProcess;
import BusinessObjects.Repository;
import BusinessObjects.Step;
import Commands.AddComponent;
import Commands.GetComponent;

public class DefineBusinessProcessController {
	Repository repository;
	
	public DefineBusinessProcessController(Repository repository){
		this.repository = repository;
	}
	
	public void addBusinessProcess(BusinessProcess businessprocess){
		
		AddComponent add = new AddComponent(repository, businessprocess);
		add.execute();
	}
	
    public void addStep(Step step,int position){
		
    	GetComponent get = new GetComponent(repository);
    	get.execute();
    	
    	BusinessProcess parent = ((List<BusinessProcess>)get.getResult()).get(position);
    	
		AddComponent add = new AddComponent(repository, parent);
		add.execute();
	}
    
    public void addAction(Step step,int position1, int position2){
		
    	GetComponent get = new GetComponent(repository);
    	get.execute();
    	
    	BusinessProcess bp = ((List<BusinessProcess>)get.getResult()).get(position1);
    	
    	get = new GetComponent(bp);
    	get.execute();
    	
    	Step parent = ((List<Step>)get.getResult()).get(position2);
    	
		AddComponent add = new AddComponent(repository, parent);
		add.execute();
	}
}
