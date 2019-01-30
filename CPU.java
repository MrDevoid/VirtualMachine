package tp.pr1.mv;

public class CPU {
	private Memory memoria;
	private OperandStack pila;
	private boolean halt;
	
	public CPU(){
		this.memoria=new Memory(1000);
		this.pila=new OperandStack();
		this.halt=false;
	}
	
	
	public boolean execute (ByteCode inst){
		Integer sumando1,sumando2;
		
		if(inst==null) return false;
		else {
			switch(inst.getName()){
				case PUSH: 
					this.pila.anadirPila(inst.getParam());
					break;			
				case STORE:
					if(this.pila.vacia()) return false;
					int numero = this.pila.sacarPila();
					this.memoria.write(inst.getParam(),numero);
					break;			
				case LOAD: 
					Integer num=this.memoria.read(inst.getParam());
					if(num == null) return false;
					this.pila.anadirPila(num);
					break;			
				case ADD:
					if(this.pila.vacia()) return false;
					sumando1=this.pila.sacarPila();
					if(this.pila.vacia()) return false;
					sumando2=this.pila.sacarPila();
					this.pila.anadirPila(sumando1+sumando2);
					break;			
				case SUB:
					if(this.pila.vacia()) return false;
					sumando1=this.pila.sacarPila();
					if(this.pila.vacia()) return false;
					sumando2=this.pila.sacarPila();
					this.pila.anadirPila(sumando2-sumando1);
					break;
				case MUL:
					if(this.pila.vacia()) return false;
					sumando1=this.pila.sacarPila();
					if(this.pila.vacia()) return false;
					sumando2=this.pila.sacarPila();
					this.pila.anadirPila(sumando2*sumando1);
					break;
				case DIV:
					if(this.pila.vacia()) return false;
					sumando1=this.pila.sacarPila();
					if(this.pila.vacia()) return false;
					sumando2=this.pila.sacarPila();
					this.pila.anadirPila(sumando2/sumando1);break;
				case OUT:System.out.println(System.lineSeparator()+"     Out:  " + this.pila.sacarPila());break;				
				case HALT:
					this.halt=true;
					break;
			}
			return true;
		}
	}
	
	public boolean getHalt(){
		return this.halt;
	}

	public String toString(){
		String s="     Estado de la CPU:";
		s +=System.lineSeparator();
		s += this.memoria.toString();
		s +=System.lineSeparator();
		s +=this.pila.toString();
		s +=System.lineSeparator();
		return s;
	}
}
