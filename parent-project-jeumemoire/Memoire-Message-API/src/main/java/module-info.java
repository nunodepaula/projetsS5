module fr.ensma.a3.ia.memoire.api {
	exports ClientMessagePartie;
	exports fr.ensma.a3.ia.memoire.api.joueur;
	exports ClientMessageJeuMemory;

	requires com.google.gson;
	requires jakarta.websocket.client.api;
}