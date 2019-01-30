package tp.pr1.mv;

public enum ENUM_COMMAND {
	HELP(false), 
	QUIT(false),
	NEWINST(false), 
	RUN(false), 
	RESET(false),
	REPLACE(true);
	private final boolean param;

	
	ENUM_COMMAND(boolean param){
		this.param=param;
	}
	
	public boolean getParam(){
		return this.param;
	}
}
