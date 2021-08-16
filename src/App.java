
public class App {

	public static void main(String[] args) {
		NutritionFacts cocacolaFacts = new NutritionFacts.Builder(240, 8)
				.calories(100)
				.sodium(35)
				.carbohydrates(27)
				.build();

		System.out.println("CocaCola calories: " + cocacolaFacts.getCalories());
		
		Singleton1 instance1 = Singleton1.getInstance();
		Singleton2 instance2 = Singleton2.INSTANCE;
		Singleton3 instance3 = Singleton3.INSTANCE;
		Singleton3 instance4 = Singleton3.INSTANCE;
		instance3.setValue(120);
		System.out.println(instance4.getValue());
	}

}
