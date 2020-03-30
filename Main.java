
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		
		//-------------------------------------------------Æwiczenie 1
		//HashSet nie gwarantuje pokjawienia siê identycznych elementów, w przeciwieñstwie do TreeSet
		//Nale¿y u¿yæ TreeSet, poniewa¿ dni tygodnia siê niepowtarzaj¹ 
		//Nie, deklaracja i dodawanie elementów odbywa siê w ten sa sposób 
		
		System.out.println("-------------------Æwiczenie 1");
		
		Set<String> zbioryDni = new TreeSet<>();
//		Set<String> zbioryDni = new HashSet<>();
		
		zbioryDni.add("Poniedzialek");
		zbioryDni.add("Wtorek");
		zbioryDni.add("Sroda");
		zbioryDni.add("Czwartek");
		zbioryDni.add("Piatek");
		zbioryDni.add("Sobota");
		zbioryDni.add("Niedziela");
		
		for(String dzien: zbioryDni) {
			System.out.println(dzien);
		}
	
		//-------------------------------------------------Æwiczenie 2
		System.out.println("-------------------Æwiczenie 2");
		
		Teacher t1 = new Teacher("Amadeusz", "Kowalczyk");
		Teacher t2 = new Teacher("Mariusz", "Jaki");
		Teacher t3 = new Teacher("Tomasz", "Kot");
		Teacher t4 = new Teacher("Mateusz", "Rokowski");
	
		Map<String, Teacher> teacherMap = new HashMap<>();
		
		teacherMap.put("Programowanie", t1);
		teacherMap.put("Programowanie obiektowe", t2);
		teacherMap.put("Sieci", t3);
		teacherMap.put("Urzadzenia mobilne", t4);
	
		
		String progObiekt = "Programowanie obiektowe";
		System.out.println(progObiekt + " prowadzi: " + teacherMap.get(progObiekt));
		
		Map<Integer, List<Student>> groups = new HashMap<>();
		Student s1 = new Student("Jan", "Kowalski");
		Student s2 = new Student("Eugeniusz", "Opalinski");
		Student s3 = new Student("Norbert", "Moraczewski");
		Student s4 = new Student("Olaf", "Kozloski");
		Student s5 = new Student("Bozena", "Stach");
		Student s6 = new Student("Kaja", "Gorczynska");
		
		List<Student> group31 = new ArrayList<>();
		List<Student> group32 = new ArrayList<>();
		List<Student> group33 = new ArrayList<>();
		
		group31.add(s1);
		group31.add(s2);
		group32.add(s3);
		group32.add(s4);
		group33.add(s5);
		group33.add(s6);
		
		
		groups.put(31, group31);
		groups.put(32, group32);
		groups.put(33, group33);
		int group = 32;
		System.out.println("W grupie " + group + " s¹ osoby: " + groups.get(group));
		
		
		
		//-------------------------------------------------Æwiczenie 3
		System.out.println("-------------------Æwiczenie 3");
		
		
		List<Product> products = new ArrayList<>();
		Map<Integer, Product> produkty = new HashMap<>();
		Map<String, ArrayList<Product>> kategorie = new HashMap<>();
		try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {
		    String s = in.readLine();
		    while(s != null) {
		    	String[] pola = s.split(";");
		    	String id = pola[0];
		    	Integer iD = Integer.parseInt(id);
	    		String cena = pola[3];
    			double cenaD = Double.parseDouble(cena);
		    	products.add(new Product(iD, pola[1], pola[2], cenaD));
		    	produkty.put(iD, new Product(iD, pola[1], pola[2], cenaD));
		    	if (kategorie.containsKey(pola[2]))
                {
                    kategorie.get(pola[2]).add(new Product(iD, pola[1], pola[2], cenaD));
                }
                else
                {
                    ArrayList list = new ArrayList();
                    list.add(new Product(iD, pola[1], pola[2], cenaD));
                    kategorie.put(pola[2], list);
                }
		    	s = in.readLine();
		    
		    }


		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		

		int produkt = 101;
		System.out.println("Produkt z ID " + produkty.get(produkt));
		
		System.out.println("-------------- " );
		String kategoria = "oprogramowanie";
		System.out.println("Kategoria: " + kategoria);
		kategorie.get(kategoria).forEach(System.out::println);

	
	}

}
