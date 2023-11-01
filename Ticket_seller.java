package Ticket;
import java.util.*;


public class Ticket_seller {
	static ArrayList<String> vId = new ArrayList<String>();
	static ArrayList<String> vGender = new ArrayList<String>();
	static ArrayList<String> vNama = new ArrayList<String>();
	static ArrayList<Integer> vTiket = new ArrayList<Integer>();
	static ArrayList<Integer> vHarga = new ArrayList<Integer>();
	static ArrayList<String> vStatus = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		int menu;
		do{
		
			System.out.println("1. Add Pembelian:");
			System.out.println("2. Update Status Pembayaran:");
			System.out.println("3. Pembatalan Pembelian:");
			System.out.println("4. Laporan Pembelian:");
			
			do {
				System.out.println("Pilih : ");
				menu = sc.nextInt();
				sc.nextLine();
			}while(menu < 1 || menu > 4);
			
			switch(menu){
				case 1:
					InputData();
				break;
					
				case 2: 
					UpdateData();
				break;
				
				case 3:
					DeleteData();
				break;
					
				case 4:
					viewData();
				break;
			
			}
		}while(menu != 5);
		
	}
	
	public static void viewData() {
		for ( int i = 0; i < vId.size(); i++) {
			System.out.println(vId.get(i) + "|" + vNama.get(i) + "|" + vGender.get(i) + "|" + vTiket.get(i) + "|" + "Rp." + vHarga.get(i) + "|" + vStatus.get(i) );
		}
		return;
	}
	
	public static void DeleteData() {
		String TicketID;
		
		System.out.println("ID Tiket: ");
		TicketID = sc.nextLine();
		
		if (vId.contains(TicketID)) {
			int pos = vId.indexOf(TicketID);
			vNama.remove(pos);
			vGender.remove(pos);
			vTiket.remove(pos);
			vHarga.remove(pos);
			vStatus.remove(pos);
			vId.remove(pos);
			
			System.out.println("Delete Successful");
			sc.nextLine();
		} else {
			System.out.println("Data no found");
			sc.nextLine();
			return;
		}
	}
	
	public static void UpdateData() {
		String TicketID;
		
		System.out.println("ID Tiket: ");
		TicketID = sc.nextLine();
		
		if (vId.contains(TicketID)) {
			int pos = vId.indexOf(TicketID);
			vStatus.set(pos, "Success Payment");
			System.out.println("Paymen Successful");
			sc.nextLine();
		} else {
			System.out.println("Data no found");
			sc.nextLine();
			return;
		}
	}
	
	public static void InputData() {
		
		String tempId = getId();
		vId.add(tempId);
		
		String tempNama;
		String tempGender;
		int tempTiket;
		
		do {
			System.out.println("Input Nama[5-30]: ");
			tempNama = sc.nextLine();
		}while(tempNama.length() < 3 || tempNama.length() > 30);
		vNama.add(tempNama);
		
		do {
			System.out.println("Input Gender[Pria/Wanita]: ");
			tempGender = sc.nextLine();
		}while(!tempGender.equals("Pria") && !tempGender.equals("Wanita"));
		vGender.add(tempGender);
		
		System.out.println("Input Jumlah Tiket: ");
		tempTiket = sc.nextInt();
		vTiket.add(tempTiket);  
		
		int tempHarga = tempTiket * 500000;
		vHarga.add(tempHarga);
		
		vStatus.add("Waiting Payment");
		
		int pos = vId.indexOf(tempId);
		System.out.println(vId.get(pos) + "|" + vNama.get(pos) + "|" + vGender.get(pos) + "|" + vTiket.get(pos) + "|" + "Rp." + vHarga.get(pos) + "|" + vStatus.get(pos) );
		return;
	}
	
	
	
	public static String getId() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String randomString = "";
		int length = 5;
		Random rand = new Random();
		
		char[] text = new char[length];
		
		for(int i = 0; i < length; i++) {
			text[i] = characters.charAt(rand.nextInt(characters.length()));
					
		}
		for(int i = 0; i < text.length; i++) {
			randomString += text[i];
		}
		
		return randomString;
	}
}

