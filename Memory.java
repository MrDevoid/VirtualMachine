package tp.pr1.mv;

public class Memory {
	private Integer[] memory;
	
	public Memory(int tamano){
		this.memory = new Integer[tamano];
	}
	
	private void copiar(Memory arrayn){
		for(int i=0;i<this.memory.length; ++i){
			arrayn.memory[i]=this.memory[i];			
		}		
	}
	
	public boolean write(int pos, int value){
		if(pos>=0){
			if(pos>this.memory.length-1){
				Memory arrayn=new Memory(pos+1);
				this.copiar(arrayn);
				this.memory = arrayn.memory;
				memory[pos] = value;	
			}			
			else {
			memory[pos]=value;
			}
			return true;
		}
		else return false;		
	}

	public Integer read(int pos){
		if (pos>=0 && pos<this.memory.length){
		return memory[pos];
		}
		else return null;
	}
	
	public String toString(){
		String s = "          Memoria: ";
		boolean ok = false;
		
		for(int i = 0; i<this.memory.length; i++){
			if(this.memory[i] != null){
				s += "[" + i +"]:" + this.memory[i] + " "; 
				ok = true;
			}
		}
		if(!ok){
			s+= "<vacia>";
		}
		return s;
	}
}
