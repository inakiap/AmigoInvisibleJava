package AI;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		//String to = "inakiap@gmail.com";
		//String subject = "Test Gmail";
		//String body = "Texto del mensaje";
		//SendEmailSSL.sendEmail(to, subject, body);
		try {
			sorteo(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}

	public static void sorteo(Boolean envio) throws IOException {
		// Leer los datos de los participantes
		System.out.println("*** CONFIGURACION");
		System.out.println("\n");
		
		Participante participantes[] = Configuracion.ObtenerParticipantes();
		System.out.println("\n");
		System.out.println("*** EMPIEZA EL SORTEO");
		System.out.println("\n");
		
		ArrayList<Participante[]> resultadoSorteo = Permutaciones.Sorteo(participantes);
		System.out.println("\n");
		System.out.println("*** ENVIO DE LOS CORREOS");
		System.out.println("\n");
		System.out.println("Pulsa ENTER para continuar");
		System.in.read();
		
		int contador = 1;
		for (Participante[] participante : resultadoSorteo) {
				
			String toEmail = participante[0].email;
			String subject = "Resultado del sorteo del amigo invisible 2019";
			String body = "¡Hola! " + participante[0].nombre +"\n\n"
					+ "Tu amigo invisible es.........." + participante[1].nombre + "\n\n\n\n"
					+ "Y RECUERDA, NO CONTESTES A ESTE CORREO \n"
					+ "Mejor envia un correo nuevo si me quieres confirmar que te llegó, en principio yo sé que si se envía o no."
					+ "\n\n"
					+ "Ahora solo faltan las listas, eso sí que sí Mándalo al grupo:\n"
					+ "amigoinvisiblePL@googlegroups.com"
					+ "\n\n"
					+ "Un beso,\n"
					+ "Iñaki";
			
			System.out.print(contador + " ");
			System.out.print(toEmail + "	\n");
			System.out.print(subject + "	\n");
			System.out.print(body);
			System.out.println("\n");
			
			if (envio) {
				SendEmailSSL.sendEmail(toEmail, subject, body);  
			}
			
			contador ++;
		}
		System.out.println("\n");	
		System.out.println("*** ACABÓ EL SORTEO");
		
		System.in.read();

	}


}
