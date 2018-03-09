//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
//import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Random;

import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	
	public MadLib()
	{



	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadVerbs();
		loadAdjectives();
		String story;
		
		try{
			Scanner file = new Scanner(new File(fileName));
		story = file.nextLine();
		for (int i = 0; i<story.length(); i++) {
			if (story.charAt(i) == '#') {
				story = story.substring(0,i) + getRandomNoun() + story.substring(i+1);
			}
			else if (story.charAt(i) == '@') {
				story = story.substring(0,i) + getRandomVerb() + story.substring(i+1);
			}
			else if (story.charAt(i) == '&') {
				story = story.substring(0,i) + getRandomAdjective() + story.substring(i+1);
			}
		}
		out.println(story);
		
		
		file.close();
		
	
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		nouns.clear();
		try{
			Scanner file = new Scanner(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 10\\src\\nouns.dat"));
			while (file.hasNextLine()) {
				nouns.add(file.nextLine());
			}
			file.close();
			nouns.remove(" ");
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
		
	}
	
	public void loadVerbs()
	{
		verbs.clear();
		try{
			Scanner file = new Scanner(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 10\\src\\verbs.dat"));
			while (file.hasNextLine()) {
				verbs.add(file.nextLine());
			}
			file.close();
			verbs.remove(" ");
	
	
	
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void loadAdjectives()
	{
		adjectives.clear();
		try{
			Scanner file = new Scanner(new File("C:\\Users\\jimlu\\Documents\\GitHub\\APCompSciMauro\\Unit 10\\src\\adjectives.dat"));
			while (file.hasNextLine()) {
				adjectives.add(file.nextLine());
			}
			file.close();
			adjectives.remove(" ");
	
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getRandomVerb()
	{
		Random rand = new Random();
		
		return verbs.get(rand.nextInt(verbs.size()));
	}
	
	public String getRandomNoun()
	{
		Random rand = new Random();
		return nouns.get(rand.nextInt(nouns.size()));
	}
	
	public String getRandomAdjective()
	{
		
		Random rand = new Random();
		
		return adjectives.get(rand.nextInt(adjectives.size()));
	}		

	public String toString()
	{
	   return "\n\n\n";
	}
}