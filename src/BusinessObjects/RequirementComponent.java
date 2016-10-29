package BusinessObjects;

public class RequirementComponent {
	
private Phrase phrase;

public RequirementComponent(Phrase p)
{
	this.phrase=p;
}

public Phrase getPhrase() {
	return phrase;
}

public void setPhrase(Phrase phrase) {
	this.phrase = phrase;
}

}
