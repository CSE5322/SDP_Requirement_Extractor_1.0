package BusinessObjects;


import java.util.ArrayList;

public class Repository {
	
	private ArrayList<BusinessProcess> businessProcessList;
	
	public ArrayList<BusinessProcess> getBusinessProcessList() {
		return businessProcessList;
	}

	public void setBusinessProcessList(ArrayList<BusinessProcess> businessProcessList) {
		this.businessProcessList = businessProcessList;
	}

	public Repository()
	{
		businessProcessList = new ArrayList<BusinessProcess>();
	}
	

	
	
}
