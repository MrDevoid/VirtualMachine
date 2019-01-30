package tp.pr1.mv;



public class ByteCode {
	private ENUM_BYTECODE name;
	private Integer param;
	
	public ByteCode(ENUM_BYTECODE op, Integer param){
		this.name=op;
		this.param=param;	
	}
	
	public ByteCode (ENUM_BYTECODE op){
		this.name=op;
	}
	
	public ENUM_BYTECODE getName(){
		return this.name;
	}
	
	public Integer getParam(){
		return this.param;
	}
	
	public String toString(){
		String s="";
		s +=this.name.name()+" ";
		if(this.name.getParam())
			s +=this.param;
		return s;
	}	
}



