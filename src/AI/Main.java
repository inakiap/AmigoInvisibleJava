package AI;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		
		// Leer los datos de los participantes
		System.out.println("*** CONFIGURACION");
		
		Participante participantes[] = Configuracion.ObtenerParticipantes();
					
		System.out.println("*** EMPIEZA EL SORTEO");
		
		ArrayList<Participante[]> resultadoSorteo = Permutaciones.Sorteo(participantes);
		
		System.out.println("*** ENVIO DE LOS CORREOS");
		
		int contador = 1;
		
		for (Participante[] participante : resultadoSorteo) {
			
			
			String toEmail = participante[0].email;
			String subject = "Resultado del sorteo del amigo invisible 2018";
			String body = "¡Hola!" + participante[0].nombre +"\n"
					+ "Tu amigo invisible es.........." + participante[1].nombre;
			
			System.out.print(contador + " ");
			System.out.print(toEmail + "	\n");
			System.out.print(subject + "	\n");
			System.out.print(body);
			System.out.println("\n");
			
			EmailUtil.EnvioEmail(toEmail, subject, body);  
			
			contador ++;
		}
		
		try { 
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
						
	}


}
