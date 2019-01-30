package tp.pr1.mv;

import java.util.Scanner;

public class Engine {
	private ByteCodeProgram programa;
	private boolean end;
	private static Scanner sc=new Scanner(System.in);
	
	public Engine(){
		this.programa=new ByteCodeProgram();
		this.end=false;
	}
	
	public void start(){
		while(!this.end){
			System.out.print("> ");
			String com=sc.nextLine();
			Command comando=CommandParser.parse(com);
			if(comando!=null){
				System.out.print("Comienza la ejecucion de " + comando.toString());
				if(!comando.execute(this)){
					System.out.println("     Error: Ejecucion incorrecta del comando");
				}
				
				if(this.programa.getCont() !=0) System.out.print(this.programa);
				if(comando.equals("QUIT")) System.out.println("Fin de la ejecucion...");
			}
			else System.out.println("Error: Comando incorrecto"+System.lineSeparator());			
		}
		sc.close();
	}
	public boolean ejecutarHelp(){
	System.out.println("     HELP: Muestra esta ayuda" +System.lineSeparator() +"     QUIT: Cierra la aplicacion"+System.lineSeparator()+
		"     RUN: Ejecuta el programa" +System.lineSeparator()+ "     NEWINST BYTECODE: Introduce una nueva instruccion al programa" +System.lineSeparator()+
		"     RESET: Vacia el programa actual"+System.lineSeparator() +	"     REPLACE N: Reemplaza la instruccion N por la solicitada al usuario"+System.lineSeparator());
	return true;
	}
	public boolean ejecutarQuit(){
		this.end=true;
		return true;
	}
	public boolean ejecutarRun(){
		CPU maquina=new CPU();
		int i=0;
		while (i<this.programa.getCont() && !maquina.getHalt() && maquina.execute(this.programa.devolverInst(i))){
			System.out.println(System.lineSeparator() + "     El estado de la maquina tras ejecutar el bytecode " + this.programa.devolverInst(i).toString()+" es:");
			System.out.print(maquina.toString());
			
			++i;}
		if(i==this.programa.getCont() || maquina.getHalt()) return true;
		else return false;
	}
	public boolean ejecutarNewinst(ByteCode inst){
		return this.programa.anyadirByteCode(inst);
	}
	public boolean ejecutarReset(){
		return this.programa.inicializarPrograma();
	}
	public boolean ejecutarReplace(int param){
		if(param <this.programa.getCont()){
		System.out.print("     Nueva instruccion: ");
		String aux=sc.nextLine();
		ByteCode inst= ByteCodeParser.parse(aux);
			if(inst!=null){
				return this.programa.sustituirInst(inst, param);
			}
			else return false;
		}
		else return false;
	}
}


