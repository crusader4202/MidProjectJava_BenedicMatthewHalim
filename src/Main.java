import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;


public class Main {
	Scanner scan = new Scanner(System.in);
	Vector<karyawan> Karyawan = new Vector<>();
	Random rand = new Random();
	
	public static void cls() {  
	    for(int i=0; i<20; i++) {
	    	System.out.println();
	    }
	}
	
	public void Ascending() {
		for (int i=0; i<Karyawan.size();i++) {
			for (int j=0; j<Karyawan.size()-1;j++) {
				
				String name1 = Karyawan.get(j).getNama();
				String name2 = Karyawan.get(j+1).getNama();
				
				if (name1.compareTo(name2) > 0) {
					karyawan temp = Karyawan.get(j);
					Karyawan.set(j, Karyawan.get(j+1));
					Karyawan.set(j+1, temp);
				}
				
			}
		}
	}
	
	public String idGenerator() {
		String id = "";
		
		id += (char) (rand.nextInt(26) + 'A');
		id += (char) (rand.nextInt(26) + 'A');
		id += "-";
		id += rand.nextInt(9);
		id += rand.nextInt(9); 
		id += rand.nextInt(9); 
		id += rand.nextInt(9);
		return id;
	}
	
	public void View() {
		cls();
		for(int i = 0; i < Karyawan.size(); i++) {
			System.out.println((i+1) + ".");
			System.out.println("Kode Karyawan			: " + Karyawan.get(i).getId());
			System.out.println("Nama Karyawan			: " + Karyawan.get(i).getNama());
			System.out.println("Jenis Kelamin Karyawan		: " + Karyawan.get(i).getJenis());
			System.out.println("Jabatan Karyawan		: " + Karyawan.get(i).getJabatan());
			System.out.println("Gaji Karyawan			: " + Karyawan.get(i).getGaji());
			System.out.println("");
		}
		System.out.print("Press Enter to continue...");
	}
	
	public void Insert() {
		cls();
		String nama_karyawan = "", kode_karyawan = "", jenis_karyawan = "", jabatan_karyawan = "";
		int gaji_karyawan = 0;
		
		kode_karyawan = idGenerator();
		
		while(true) {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama_karyawan = scan.nextLine();
			
			if(nama_karyawan.length() >= 3) {
				break;
			}
			System.out.println("nama karyawan harus lebih dari 3 karakter");
		}
		
		while(true) {
			System.out.print("Input jenis kelamin karyawan [Laki-Laki | Perempuan] (Case Sensitive): ");
			jenis_karyawan = scan.nextLine();
			
			if(jenis_karyawan.equals("Laki-Laki") || jenis_karyawan.equals("Perempuan")) {
				break;
			}
			System.out.println("Jenis kelamin harus diantara Laki-Laki/Perempuan");
		}
		
		while(true) {
			System.out.print("Input jabatan karyawan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan_karyawan = scan.nextLine();
			
			if(jabatan_karyawan.equals("Manager") || jabatan_karyawan.equals("Supervisor") || jabatan_karyawan.equals("Admin")) {
				break;
			}
			System.out.println("Jabatan harus diantara Manager/Supervisor/Admin");
		}
		
		System.out.println("Berhasil menambahkan karyawan dengan id " + kode_karyawan);
		System.out.println("Enter to return...");
		scan.nextLine();
		
		int countM = 0, countS = 0, countA = 0;
		
		if(jabatan_karyawan == "Manager") {
			gaji_karyawan = 8000000;
			countM++;
		}
		else if(jabatan_karyawan == "Supervisor") {
			gaji_karyawan = 6000000;
			countS++;
		}
		else {
			gaji_karyawan = 4000000;
			countA++;
		}
		Karyawan.add(new karyawan(kode_karyawan, nama_karyawan, jenis_karyawan, jabatan_karyawan, gaji_karyawan));
		Ascending();
		
		if(countM == 4 || countM == 7) {
			for(int i = 0; i < Karyawan.size(); i++) {
				if(Karyawan.get(i).getJabatan().equals("Manager")) {
					int temp = (int) (Karyawan.get(i).getGaji() * 1.1);
					Karyawan.get(i).setGaji(temp);
				}
			}
		}
		
		if(countS == 4 || countS == 7) {
			for(int i = 0; i < Karyawan.size(); i++) {
				if(Karyawan.get(i).getJabatan().equals("Supervisor")) {
					int temp = (int) (Karyawan.get(i).getGaji() * 1.075);
					Karyawan.get(i).setGaji(temp);
				}
			}
		}
		
		if(countA == 4 || countA == 7) {
			for(int i = 0; i < Karyawan.size(); i++) {
				if(Karyawan.get(i).getJabatan().equals("Admin")) {
					int temp = (int) (Karyawan.get(i).getGaji() * 1.05);
					Karyawan.get(i).setGaji(temp);
				}
			}
		}
	}
	
	public void Update() {
		View();
		System.out.println("");
		String nama_karyawan = "", jenis_karyawan = "", jabatan_karyawan = "";
		int gaji_karyawan = 0, idx = 1;
		
		while(idx < 0 || idx > Karyawan.size()) {
			System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
			idx = scan.nextInt();
			scan.nextLine();
		}
		
		if(idx == 0) {
			return;
		}
		
		while(true) {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama_karyawan = scan.nextLine();
			
			if(nama_karyawan.length() >= 3) {
				break;
			}
			System.out.println("nama karyawan harus lebih dari 3 karakter");
		}
		
		while(true) {
			System.out.print("Input jenis kelamin karyawan [Laki-Laki | Perempuan] (Case Sensitive): ");
			jenis_karyawan = scan.nextLine();
			
			if(jenis_karyawan.equals("Laki-Laki") || jenis_karyawan.equals("Perempuan")) {
				break;
			}
			System.out.println("Jenis kelamin harus diantara Laki-Laki/Perempuan");
		}
		
		while(true) {
			System.out.print("Input jabatan karyawan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan_karyawan = scan.nextLine();
			
			if(jabatan_karyawan.equals("Manager") || jabatan_karyawan.equals("Supervisor") || jabatan_karyawan.equals("Admin")) {
				break;
			}
			System.out.println("Jabatan harus diantara Manager/Supervisor/Admin");
		}
		
		if(jabatan_karyawan.equals("Manager")) {
			gaji_karyawan = 8000000;
		}
		else if(jabatan_karyawan.equals("Supervisor")) {
			gaji_karyawan = 6000000;
		}
		else {
			gaji_karyawan = 4000000;
		}
		
		Karyawan.get(idx-1).setNama(nama_karyawan);
		Karyawan.get(idx-1).setJenis(jenis_karyawan);
		Karyawan.get(idx-1).setJabatan(jabatan_karyawan);
		Karyawan.get(idx-1).setGaji(gaji_karyawan);
		
		System.out.println("Berhasil mengupdate karyawan dengan id " + Karyawan.get(idx-1).getId());
		System.out.println("Enter to return...");
		scan.nextLine();
	}
	
	public void Delete() {
		View();
		System.out.println("");
		
		int idx = 0;
		
		while(idx < 1 || idx > Karyawan.size()) {
			System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
			idx = scan.nextInt();
			scan.nextLine();
		}
		System.out.println("Berhasil menghapus karyawan dengan id " + Karyawan.get(idx-1).getId());
		Karyawan.remove(idx-1);
		System.out.println("Enter to return...");
		scan.nextLine();
	}
	
	public Main() {
		int menu = 0;
		while(true) {
			try {
				cls();
				System.out.println("PT Musang");
				System.out.println("1. Insert data");
				System.out.println("2. View data");
				System.out.println("3. Update data");
				System.out.println("4. Delete data");
				System.out.print("Choose: ");
				menu = scan.nextInt();
				scan.nextLine();
				
				if(menu < 1 || menu > 4) {
					System.out.println("Must be between 1 and 4");
					scan.nextLine();
					continue;
				}
				
			} catch (Exception e) {
				System.out.println("Must be a number");
			}
			if(menu == 1) {
				Insert();
			}
			if(menu == 2) {
				View();
				scan.nextLine();
			}
			if(menu == 3) {
				Update();
			}
			if(menu == 4) {
				Delete();
			}
		}
		
	}

	public static void main(String[] args) {
		new Main();
	}

}
