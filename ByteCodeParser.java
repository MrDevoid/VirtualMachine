package tp.pr1.mv;

public class ByteCodeParser {
	
	
	public static ByteCode parse(String line){
		ByteCode inst=null;
		ENUM_BYTECODE enumerado=null;
		Integer posicion=null;
		String s= line.trim();
		String [] sv=s.split(" +");
		
		switch(sv[0].toUpperCase()){			
			case "PUSH":
				enumerado=ENUM_BYTECODE.PUSH;
				posicion=Integer.parseInt(sv[1]);
				inst=new ByteCode(enumerado,posicion);
				break;			
			case "STORE":
				enumerado=ENUM_BYTECODE.STORE;
				posicion=Integer.parseInt(sv[1]);
				inst=new ByteCode(enumerado,posicion);
				break;			
			case "LOAD":
				enumerado=ENUM_BYTECODE.LOAD;
				posicion=Integer.parseInt(sv[1]);
				inst=new ByteCode(enumerado,posicion);
				break;
			case "ADD":
				enumerado=ENUM_BYTECODE.ADD;
				inst=new ByteCode(enumerado);
				break;			
			case "SUB":
				enumerado=ENUM_BYTECODE.SUB;
				inst=new ByteCode(enumerado);
				break;			
			case "MUL":
				enumerado=ENUM_BYTECODE.MUL;
				inst=new ByteCode(enumerado);
				break;			
			case "DIV":
				enumerado=ENUM_BYTECODE.DIV;
				inst=new ByteCode(enumerado);
				break;			
			case "OUT":
				enumerado=ENUM_BYTECODE.OUT;
				inst=new ByteCode(enumerado);
				break;			
			case "HALT":
				enumerado=ENUM_BYTECODE.HALT;
				inst=new ByteCode(enumerado);
				break;
		}
		return inst;
	}
}

