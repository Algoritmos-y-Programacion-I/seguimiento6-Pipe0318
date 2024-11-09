package ui;

import java.util.Scanner;

import model.Fauna;
import model.Flora;
import model.Species;
import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Show species info");
			System.out.println("4. Delete a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:	
					showSpecies();
					break;
				case 4:
					deleteSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;

			}

		}

	}

	public void registerSpecies() {
		reader.nextLine();
		System.out.println("Type the new Species' name: ");
		String name = reader.nextLine();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.nextLine();

		System.out.println("Is it 1. Fauna or 2. Flora?");
		int type = reader.nextInt();
		

		switch (type) {
			case 1:

				System.out.println("Is it migratory?");
				boolean migratory = reader.nextBoolean();

				System.out.println("What is the maximum weight?");
				double maxWeight = reader.nextDouble();

				if (speciesController.registerFauna(name, scientificName, migratory, maxWeight)) {

					System.out.println("Species registered successfully");

				} else {

					System.out.println("Error, Species couldn't be registered");
				}

				break;

			case 2:

				System.out.println("It has flowers?");
				boolean flowers = reader.nextBoolean();

				System.out.println("It has fruits?");
				boolean fruits = reader.nextBoolean();

				System.out.println("What is the maximum height?");
				double maxHeight = reader.nextDouble();

				if (speciesController.registerFlora(name, scientificName, flowers, fruits, maxHeight)) {

					System.out.println("Species registered successfully");

				} else {

					System.out.println("Error, Species couldn't be registered");
				}

				break;

			default:

				System.out.println("You must type a valid option");
				break;
		}

	}

	public void editSpecies() {

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showSpeciesList();

		if (query != null) {
			System.out.println(query);
			System.out.print("Type the species you want to modify: ");
			reader.nextLine();
			String name = reader.nextLine();

			Species foundSpecies = speciesController.searchSpecies(name);

			if (foundSpecies != null) {
				System.out.println("Found species: " + foundSpecies.getName());

				if (foundSpecies instanceof Fauna) {
					Fauna faunaSpecies = (Fauna) foundSpecies;
					System.out.println("Scientific Name: " + faunaSpecies.getScientificName());
					System.out.println("Migratory: " + faunaSpecies.isMigratory());
					System.out.println("Max Weight: " + faunaSpecies.getMaxWeight());

				} else if (foundSpecies instanceof Flora) {
					Flora floraSpecies = (Flora) foundSpecies;
					System.out.println("Scientific Name: " + floraSpecies.getScientificName());
					System.out.println("Flowers: " + floraSpecies.isFlowes());

				}

				if (foundSpecies instanceof Fauna) {
					System.out.println("Wich attribute do you want to edit?");
					System.out.println("1. Name");
					System.out.println("2. Scientific Name");
					System.out.println("3. Migratory State");
					System.out.println("4. Max Weight");
					int option = reader.nextInt();

					switch (option) {
						case 1:
							System.out.println("Enter the species new Name:");
							String newName = reader.nextLine();
							reader.nextLine();
							((Fauna) foundSpecies).setName(newName);
							System.out.println("Name updated successfully!");

							break;
						case 2:

							System.out.print("Enter the species new Scientific Name: ");
							String newScientificName = reader.nextLine();
							reader.nextLine();
							((Fauna) foundSpecies).setScientificName(newScientificName);
							System.out.println("Scientific Name updated successfully!");

							break;
						case 3:
							System.out.print("Enter the species new Migratory state: ");
							boolean newMigratory = reader.nextBoolean();
							reader.nextLine();
							((Fauna) foundSpecies).setMigratory(newMigratory);
							System.out.println("Migratory state updated successfully!");

							break;
						case 4:

							System.out.print("Enter the species new Max Weight: ");
							double newMaxWeight = reader.nextDouble();
							reader.nextLine();
							((Fauna) foundSpecies).setMaxWeight(newMaxWeight);
							System.out.println("Max Weight updated successfully!");

							break;

						default:
							System.out.println("You must type a valid option");
							break;
					}

				} else if (foundSpecies instanceof Flora) {

					System.out.println("Wich attribute do you want to edit?");
					System.out.println("1. Name");
					System.out.println("2. Scientific Name");
					System.out.println("3. Flowers State");
					System.out.println("4. Fruits State");
					System.out.println("5. Max Height");
					int option = reader.nextInt();

					switch (option) {
						case 1:
							System.out.println("Enter the species new Name:");
							String newName = reader.nextLine();
							reader.nextLine();
							((Flora) foundSpecies).setName(newName);
							System.out.println("Name updated successfully!");

							break;
						case 2:

							System.out.print("Enter the species new Scientific Name: ");
							String newScientificName = reader.nextLine();
							reader.nextLine();
							((Flora) foundSpecies).setScientificName(newScientificName);
							System.out.println("Scientific Name updated successfully!");

							break;
						case 3:
							System.out.print("Enter the species new Flowers state: ");
							boolean newFlowerState = reader.nextBoolean();
							reader.nextLine();
							((Flora) foundSpecies).setFlowes(newFlowerState);
							System.out.println("Flowers state updated successfully!");

							break;
						case 4:
							System.out.print("Enter the species new Fruits state: ");
							boolean newFruit = reader.nextBoolean();
							reader.nextLine();
							((Flora) foundSpecies).setFruits(newFruit);
							;
							System.out.println("Fruits state updated successfully!");
							break;

						case 5:

							System.out.print("Enter the species new Max Height: ");
							double newMaxHeight = reader.nextDouble();
							reader.nextLine();
							((Flora) foundSpecies).setMaxHeight(newMaxHeight);
							System.out.println("Max Height updated successfully!");

							break;

						default:
							break;
					}

				}

			} else {
				System.out.println("Species not found.");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}
		
	}

	public void deleteSpecies() {

		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			System.out.println("Type the species you want to delete:");
			reader.nextLine();
			String name = reader.nextLine();
			speciesController.deleteSpecies(name);
			System.out.println("Species deleted successfully");

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void showSpecies() {
		System.out.println("Which Species do you want to review?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			System.out.print("Type the species you want to review: ");
			reader.nextLine();
			String name = reader.nextLine();
			System.out.println(speciesController.showSpeciesInfo(name));


		} else {
			System.out.println("There aren't any species registered yet");
		}


		
	}

}
