package tp.pr1.mv;

public class ByteCodeProgram {
	private final int SIZE_BYTECODE=1000;
	private ByteCode[] program;
	private int contador;
	
	public ByteCodeProgram(){
			this.program= new ByteCode[SIZE_BYTECODE];
			this.contador=0;
	}
	
	public boolean anyadirByteCode(ByteCode inst){
		if(inst==null) return false;
		this.program[this.contador]=inst;
		++this.contador;
		return true;
	}
	
	public boolean sustituirInst(ByteCode inst, int posicion){
		this.program[posicion]=inst;
		return true;
	}
	
	public boolean inicializarPrograma(){
		this.contador=0;
		return true;
	}
	
	public ByteCode devolverInst(int posicion){
		return this.program[posicion];
	}
	
	public String toString(){
		String s="Programa almacenado:"+System.lineSeparator();
		for(int i=0;i<this.contador;++i){
			s +="     " + i + ": ";
			s += this.program[i];
			s += System.lineSeparator();
		}		
		return s;
	}
	
	public int getCont(){
		return this.contador;
	}
}
