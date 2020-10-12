package model;

public enum Nationality {
	
	Brasilien,
	Kolumbien,
	Holland,
	Estland, 
	Frankreich, 
	Island, 
	Jamaika,
	Schweiz;
	
	//Überprüft ob searchString in diesem Namen vorkommt
	
	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}
	
	
}
