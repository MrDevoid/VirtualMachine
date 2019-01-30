package tp.pr1.mv;

public class OperandStack {
	private final int SIZE_STACK=1000;
	private Integer[] stack;
	private int cont;
	
	public OperandStack(){
		this.stack = new Integer[SIZE_STACK];
		this.cont = 0;
	}
	
	public void anadirPila(int num){
		if(this.cont-1 < this.stack.length){
			this.stack[this.cont] = num;
			this.cont++;
		}
	}
	
	public Integer sacarPila(){
		Integer ultimo=0;
		if(!this.vacia()){
			ultimo=this.stack[this.cont-1];
			this.cont--;			
		}
		return ultimo;
	}
	
	public boolean vacia(){
		if(this.cont>0) return false;
		else return true;
	}
	
	public String toString(){
		String p="          Pila: ";
		boolean ok=false;
		for(int i=0; i<this.cont;++i){
			p += this.stack[i]+" ";
			ok=true;
		}
		if(!ok) p += "<vacia>";
		return p;
	}
}
