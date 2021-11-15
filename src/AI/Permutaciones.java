package AI;

import java.util.*;

public class Permutaciones {

	public static ArrayList<Participante[]> Sorteo(Participante[] participantes) {
		ArrayList<Participante> receptores = new ArrayList<>(Arrays.asList(participantes));

		// Estructura para guardar las combinaciones resultantes
		ArrayList<Participante[]> combinaciones = new ArrayList<Participante[]>();
		int numeroParticipantes = participantes.length;
		int numRecept = numeroParticipantes;
		int numAzar = Permutaciones.NumeroAleatorio(numRecept);
		int i = 0;

		// Hacer combinacion con 1� emisor y un receptor al azar
		while (numeroParticipantes != i) {
			numRecept = receptores.size();

			// recorrer los participantes

			// se elije un receptor al azar
			numAzar = Permutaciones.NumeroAleatorio(numRecept);
			// System.out.println("Emisor: " + participantes[i].nombre);
			String auxNombre = receptores.get(numAzar).nombre;
			// System.out.println("Receptor: " + auxNombre);

			// si el emisor y el recepetor son distintos se busca si el participante lo
			// tiene en su lista de exclusiones
			if (!participantes[i].nombre.equals(auxNombre)) {

				/*
				 * se recorre la lista de exclusiones para encontrar si el posible receptor se
				 * encuentra en ella, si no lo est� se encontr� una combinaci�n v�lida
				 */
				if (Permutaciones.ValidarCombinacion(auxNombre, participantes[i].relaciones)) {
					Participante aux[] = { participantes[i], receptores.get(numAzar) };
					combinaciones.add(aux);
					System.out.println(i + 1 + " " + aux[0].nombre + " -> " + aux[1].nombre);
					// Borro de los receptores al elegido
					receptores.remove(numAzar);
					i++;

				}
			}

		}
		return combinaciones;
	}

	static void MostrarParticipantes(Participante[] participantes) {
		for (Participante participante : participantes) {
			System.out.println(participante.nombre);
		}
	}

	static void removeElements(Participante[] input, String deleteMe) {
		List<Participante> result = new LinkedList<Participante>();

		for (Participante item : input)
			if (!deleteMe.equals(item.nombre))
				result.add(item);
	}

	static int NumeroAleatorio(int num) {
		int respuesta;

		Random rnd = new Random();

		respuesta = rnd.nextInt(num);

		return respuesta;
	}

	static boolean ValidarCombinacion(String nombre, String[] nombres) {
		boolean respuesta = true;

		if (null != nombres) {
			for (String aux : nombres) {

				if (nombre.equals(aux)) {
					respuesta = false;
					break;
				}

			}
		}

		return respuesta;

	}

}
