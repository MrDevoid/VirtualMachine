package tp.pr1.mv;

public enum ENUM_BYTECODE {
	PUSH(true), 
	STORE(true), 
	LOAD(true), 
	ADD(false), 
	SUB(false),
	MUL(false),
	DIV(false),
	OUT(false),
	HALT(false);
	
	private final boolean param;
	
	ENUM_BYTECODE(boolean param){
		this.param=param;
	}
	
	public boolean getParam(){
		return this.param;
	}
}
