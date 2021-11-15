package AI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class Configuracion {

	private static Properties prop;

	private static void ObtenerPropiedades() {

		prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("participantes.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			// System.out.println(prop.getProperty("database"));
			// System.out.println(prop.getProperty("dbuser"));
			// System.out.println(prop.getProperty("dbpassword"));

		} catch (IOException ex) {

			ex.printStackTrace();

		} finally {
			if (input != null) {
				try {
					input.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static Participante[] ObtenerParticipantes() {

		ObtenerPropiedades();

		String aux = prop.getProperty("participantes");

		String participantesAux[] = aux.split(",");

		ArrayList<Participante> participantesList = new ArrayList<Participante>();

		for (int i = 0; i < participantesAux.length; i++) {

			Participante p = new Participante();
			String pRaw = prop.getProperty(participantesAux[i]);
			String aux2[] = pRaw.split(",");

			p.nombre = participantesAux[i];
			p.email = aux2[0];
			if (aux2.length > 1) {
				p.relaciones = aux2[1].split(";");
			} else {
				p.relaciones = null;
			}

			participantesList.add(p);

			System.out.print(p.nombre + "	");
			System.out.print(p.email + "	");
			if (null != p.relaciones) {
				for (String string : p.relaciones) {
					System.out.print(string + "	");
				}
			}
			System.out.println("");

		}

		Participante[] resultado = new Participante[participantesList.size()];
		resultado = participantesList.toArray(resultado);

		return resultado;

	}

}
