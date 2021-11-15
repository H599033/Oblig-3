package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {
	
	Innlegg [] innleggtabell;
	private int antall;
	
	public Blogg() {
		innleggtabell = new Innlegg[20];
		antall=0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		antall=0;
	}

	public int getAntall() {
		return antall;
	}
	
	public Innlegg[] getSamling() {
		
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) 
	{
		for(int i = 0; i < antall; i++) {
			if(innleggtabell[i].erLik(innlegg)) {
				
				return i;
			}	
		}
		return -1;
	}
	

	public boolean finnes(Innlegg innlegg) {
		if(finnInnlegg(innlegg)==-1) {
			return false;
		}else
			return true;
	}

	public boolean ledigPlass() {
		if(antall<innleggtabell.length) {
			return true;
		}
		else {
			return false;}
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
		
		if(ledigPlass() && finnInnlegg(innlegg) == -1) 
		{
			innleggtabell[antall] =innlegg;
			antall++;
			return true;
		}else
			return false;
		
	}
	
	public String toString() {
		
		String b = "";
		for(int i = 0; i < antall; i++) {
			b += innleggtabell[i].toString();
		}
		return antall+  "\n"+b;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		int length = innleggtabell.length;
		Innlegg [] Uinnleggtabell = new Innlegg[length*2];
		for (int i =0; i<antall; i++) 
		{
			Uinnleggtabell[i]=innleggtabell[i];
		}
		innleggtabell=Uinnleggtabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if(ledigPlass()) 
		{
			if(finnes(innlegg)==false) 
			{
				leggTil(innlegg);
				return true;
			}else
				return false;
		}else 
		{
			utvid();
			if(finnes(innlegg)==false) 
			{
				leggTil(innlegg);
				return true;
			}else
				return false;
		}
	}

	public boolean slett(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		
		if(pos>0) 
		{
			antall--;
			innleggtabell[pos]=innleggtabell[antall];
			innleggtabell[antall]=null;
			return true;
			
		}else
			return false;
		
	}
	
	
	public int[] search(String keyword) {
		int stk=0;
		int [] tabell= new int [antall];
		for( int i =0; i<antall; i++) 
		{
			if(innleggtabell[i].toString().contains(keyword)) {
				tabell[stk] = innleggtabell[i].getId();
				stk++;
			}
		}
		return tabell;
	}
}