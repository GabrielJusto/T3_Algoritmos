
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Trie
{


	private class Node
	{
		
		public HashMap<Character, Node> children;
		public Character data;
		public boolean isWord;

		public Node(Character data)
		{
			children = new HashMap<>();
			this.data = data;
			isWord = false;
		}

		public void setEndWord()
		{
			isWord = true;
		}
		public boolean getIsWord()
		{
			return isWord;
		}
	}


	private Node root;

	public Trie()
	{
		root = new Node(null);
	}

	public void add(String word)
	{
		Node current = root;


		for(int i=0; i<word.length(); i++)
		{
			if(current.children.containsKey(word.charAt(i)))
				current = current.children.get(word.charAt(i));
			else
			{
				current.children.put(word.charAt(i), new Node(word.charAt(i)));
				current = current.children.get(word.charAt(i));
				
			}
		}
		current.setEndWord();
	}

	public boolean contains(String word)
	{
		Node current = root;

		for(int i=0;i<word.length(); i++)
		{
			if(current.children.containsKey(word.charAt(i)))
				current = current.children.get(word.charAt(i));
			else
				return false;
			
		}
		if(current.getIsWord())
			return true;
		return false;
	}

	public Set<String> get(String subWord)
	{
		Node current = root;
		Set<String> setString = new HashSet<>();
		for(int i=0;i<subWord.length(); i++)
		{
			if(current.children.containsKey(subWord.charAt(i)))
				current = current.children.get(subWord.charAt(i));
			else
				return null;	
		}
		subWord = subWord.substring(0,subWord.length()-1);
		get(current, setString, subWord);
		return setString;
		
	}

	private void get(Node n, Set<String> set, String s)
	{
		Set<Character> keys = n.children.keySet();
		if(n.getIsWord())
		{
			s = s+n.data;
			set.add(s);
			s = s.substring(0,s.length()-1);
		}
		for(Character c : keys)
		{
			get(n.children.get(c), set, s+n.data);
		}

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.add("carro");
		trie.add("casa");
		trie.add("cobertura");
		trie.add("apartamento");
		trie.add("aperitivo");
		trie.add("apa");
		trie.add("ape");
		trie.add("carta");
		System.out.println(trie.get("a"));
	}
}
