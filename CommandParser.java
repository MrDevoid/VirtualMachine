package tp.pr1.mv;

public class CommandParser {
	
	public static Command parse(String line){
		Command com=null;
		ENUM_COMMAND enumerado=null;
		String s= line.trim();
		String [] sv=s.split(" +");
		
		switch(sv[0].toUpperCase()){			
			case "HELP":
				enumerado=ENUM_COMMAND.HELP;
				com=new Command(enumerado);
				break;			
			case "QUIT":
				enumerado=ENUM_COMMAND.QUIT;
				com=new Command(enumerado);
				break;			
			case "NEWINST":
				enumerado=ENUM_COMMAND.NEWINST;
				ByteCode inst;
				if(sv.length>=2){
					if(sv[1].toUpperCase().equals("LOAD") || sv[1].toUpperCase().equals("PUSH") || sv[1].toUpperCase().equals("STORE")){
						if(sv.length==3){	
							inst = ByteCodeParser.parse(sv[1] + " " + sv[2]);	
						}
						else inst=null;
					}
					else inst = ByteCodeParser.parse(sv[1]);		
					com = new Command(enumerado,inst);
				}
				else return null;
				break;			
			case "RUN":
				enumerado=ENUM_COMMAND.RUN;
				com=new Command(enumerado);
				break;			
			case "RESET":
				enumerado=ENUM_COMMAND.RESET;
				com=new Command(enumerado);
				break;			
			case "REPLACE":
				enumerado=ENUM_COMMAND.REPLACE;
				if (sv.length == 2)	com = new Command(enumerado, Integer.parseInt(sv[1]));
				else com=null;				
				break;
		}		
		return com;
	}
}
