import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Main
{

	Map<String, String> dictionary;
	Trie trie;

	public Main()
	{
		dictionary = new HashMap<>();
		trie = new Trie();
	}
	public void fileRead()
	{
		String nome = "names.txt";
		String exp = null;

		try
		{
			FileReader file = new FileReader(new File(nome));
			BufferedReader buf = new BufferedReader(file);
			while((exp = buf.readLine()) != null)
			{
				String [] aux = exp.split(";");
				dictionary.put(aux[0], aux[1]);
				trie.add(aux[0]);
			}
			buf.close();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}



	public static void main(String[] args) 
	{
		Main m = new Main();
		m.fileRead();
				
	}
}