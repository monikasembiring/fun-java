package objectoriented;

public class Pond {
	public static void main (String[] args) {
		Frog frog1 = new Frog("Peepo");
		Frog frog2 = new Frog("Pepe", 10, 15);
		Frog frog3 = new Frog("Peepaw", 4.6, 5);
		Frog frog4 = new Frog("Anabul");
		
		Fly fly1 = new Fly(1, 3);
		Fly fly2 = new Fly(6);
		Fly fly3 = new Fly();
		
		//1
		frog1.setSpecies("1331 Frogs");
		frog2.setSpecies("1331 Frogs");
		frog3.setSpecies("1331 Frogs");
		frog4.setSpecies("1331 Frogs");
		
		//2
		System.out.println(frog1.toString());
		
		//3
		frog1.eat(fly2);
		
		//4
		System.out.println(fly2.toString());
		
		//5
		frog1.grow(8);
		
		//6
		frog1.eat(fly2);
		
		//7
		System.out.println(fly2.toString());
		
		//8
		System.out.println(frog1.toString());
		
		//9
		System.out.println(frog4.toString());
		
		//10
		frog3.grow(4);
		
		//11
		System.out.println(frog3.toString());
		
		//12
		System.out.println(frog2.toString());
		
	}
}
