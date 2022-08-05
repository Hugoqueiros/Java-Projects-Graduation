package principal;

public class Cliente {
	
	private String name;
	
	public Cliente() {
	}

	public Cliente(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	@Override
	public String toString() {
		return name;
 	}
}
