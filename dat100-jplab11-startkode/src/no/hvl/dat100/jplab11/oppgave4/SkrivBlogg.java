package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;



public class SkrivBlogg  {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) 
	{
		
		try {
			File fil = new File (mappe + filnavn);
			PrintWriter les =  new PrintWriter(fil);
			
			
			if(samling.getAntall()>0) {
				les.print(samling);
			}
			les.close();
			return true;
			
		}
		catch (Exception blogg) {
			System.out.println("Exception found");
			
			return false;
		}
		
	}
}
