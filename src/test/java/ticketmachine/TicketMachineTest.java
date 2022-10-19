package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante
//test git (TP du 19 Octobre)
	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}
//je rajoute un 2ème test pour vériier que c'est tout bon (TP du 19 Octobre)
	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	public void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		// Les montants ont été correctement additionnés
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");
	}

	@Test
	//S3: la balance change quand on insère de l’argent
	public void imprimer() {
		machine.insertMoney(40);
		assertEquals(false, machine.printTicket(), "le montant est insuffisant");
	}

	@Test
	//S4: on n’imprime pas le ticket si le montant inséré est insuffisant
	public void nonimprimer() {
		machine.insertMoney(60);
		assertEquals(true, machine.printTicket(), "le montant est insuffisant");
	}
	@Test
	//S5:Quand on imprime un ticket la balance est décrémentée du prix du ticket
 public void decrementee(){
	 machine.insertMoney(60);
	 machine.printTicket();
		assertEquals(10, machine.getBalance(), "il reste");
 }
	@Test
	//S6: le montant collecté est mis à jour quand on imprime un ticket (pas avant)
	public void collecte(){
		machine.insertMoney(100);
		machine.printTicket();
		assertEquals(50, machine.getBalance(), "Le montant collecté");
		machine.printTicket();
		assertEquals(0, machine.getBalance(), "Le montant collecté");
	}

	@Test
	//S7: refund() rend correctement la monnaie
	public void correctMonaie(){
		machine.insertMoney(60);
		assertEquals(60, machine.refund(), "La machine ne rend pas la monnaie");
	}
	@Test
	//S8: refund() remet la balance à zéro
	public void balanceZero(){
		machine.insertMoney(60);
		machine.refund();
		assertEquals(0, machine.getBalance(), "La machine ne rend pas la monnaie");
	}

	@Test
	//S9: on ne peut pas insérer un montant négatif
	public void nonnegatif(){
	assertThrows(IllegalArgumentException.class,
			() -> {machine.insertMoney(-10);},
			"pas de valeur negative");
	}
	@Test
	//S10:  on ne peut pas créer de machine qui délivre des tickets dont le prix est négatif
	public void pasDeMachineNegative(){
		try {
			TicketMachine machine2 = new TicketMachine(-10);
			fail("cet appel doit lever une exception");
		} catch (IllegalArgumentException ex) {

		}
		}

		//test de modification
	//TEST DE CONFLIT 2

	}

