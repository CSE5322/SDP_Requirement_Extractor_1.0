package BusinessObjects;

public class Phrase {
	private String verb;
	private String noun;
	private String setence;
	
	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getNoun() {
		return noun;
	}

	public void setNoun(String noun) {
		this.noun = noun;
	}

	public String getSetence() {
		return setence;
	}

	public void setSetence(String setence) {
		this.setence = setence;
	}

	
	public Phrase(String v, String n)
	{
		verb = v;
		noun = n;
		setence = createSentence();
	}
	
	String createSentence()
	{
		return verb + " " + noun;
	}

}
