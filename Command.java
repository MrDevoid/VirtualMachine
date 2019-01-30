package tp.pr1.mv;

public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private Integer replace;
	
	public Command(ENUM_COMMAND command, ByteCode inst){
		this.command = command;
		this.instruction = inst;	
	}
	
	public Command(ENUM_COMMAND command, Integer replace){
		this.command=command;
		this.replace=replace;
	}
	
	public Command(ENUM_COMMAND command){
		this.command=command;
	}
	
	public boolean execute(Engine engine){
		if(this.command==null) return false;
		else {
			switch(this.command){
				case HELP: return engine.ejecutarHelp();							
				case NEWINST: return engine.ejecutarNewinst(this.instruction);
				case REPLACE: return engine.ejecutarReplace(this.replace);										
				case RESET: return engine.ejecutarReset();				
				case RUN: return engine.ejecutarRun();
				case QUIT: return engine.ejecutarQuit();
			}
			return false;
		}
	}
	
	public boolean equals(String line){
		return this.command.name().equals(line);
	}
	
	public String toString(){
		String s= this.command.name();
		if(this.command.name()=="NEWINST" && this.instruction!=null)
			s+=" "+this.instruction.toString();
		if(this.command.name()=="REPLACE" && this.replace!=null)
			s+=" "+this.replace;
		s += System.lineSeparator();	
		return s;
	}
	
	public String getByteString(){
		return this.instruction.toString();
	}
}
