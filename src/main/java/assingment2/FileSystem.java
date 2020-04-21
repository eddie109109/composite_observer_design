package assingment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileSystem {


	private List<Node> nodes;
	private Directory root;

	public FileSystem(){
		nodes = new ArrayList<Node>();
		root = new Directory("root",null);
		nodes.add(root);
	}

	// return the head node of the array list so that it keeps a reference of the head
	public Directory returnHeadDirectory() {
		Directory head = (Directory) nodes.get(0);
		return head;

	}

	// this function is to check whether the node we are going to store is created or not.
	private boolean isCreated(List<Node> nodes, String name) {
		boolean sameName = false;
		for (int i = 0; i < nodes.size(); i++) {
			if ((nodes.get(i).name).equals(name) ) {
				sameName = true;
			}
		}

		Node searchNode = returnNode(nodes, name);
		if (searchNode == null || sameName == false) {
			return false;
		}
		return true;
	}

	// this function is to return the node that is already in the nodes arraylist
	private Node returnNode(List<Node> nodes, String name) {
		for (int i = 0; i< nodes.size(); i++) {
			if ((nodes.get(i).name).equals(name)) {
				return nodes.get(i);
			}
		}
		return null;
	}

	
	private String reverseString(String s) {
		StringBuilder builder = new StringBuilder();
		for (int i = s.length()-1; i >= 0; i--) {
			builder.append(s.charAt(i));
		}

		return builder.toString();
	}

	public void Import(String relativePath) {

		List<String> filepaths = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(relativePath));
			String line;
			while((line = br.readLine()) != null) {
				filepaths.add(line); // add all different file paths to the array list
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		for (int i = 0; i < filepaths.size(); i++) {
			char lastChar = filepaths.get(filepaths.size() -1).charAt((filepaths.get(filepaths.size() -1).length()-1));
			String substring = filepaths.get(i).substring(0,2);
			if (substring.equals("d:")) { // this makes sure the last node is a directory
				int lastIndex = filepaths.get(i).lastIndexOf('/');
				lastIndex--;
				String son = "";
//				String parent = "";
				Directory newDirectory = null;
				int beginIndex = 1;
				StringBuilder builder = new StringBuilder();
				for (int j = lastIndex; j >= beginIndex; j--) {

					if (Character.compare(filepaths.get(i).charAt(j), '/') ==0 || Character.compare(filepaths.get(i).charAt(j), ':') ==0) {
						String backwardString = builder.toString();
						String normalString = reverseString(backwardString);

						if (!isCreated(nodes, normalString)) {
							if (son == "") {
								son = normalString;
								newDirectory =  new Directory(son,null);
								nodes.add(newDirectory);

							}
						}
						else {
							if (!son.equals("")) {
								Directory parentDirectory = (Directory) returnNode(nodes, normalString);
								newDirectory.parent = parentDirectory;
								parentDirectory.addNode(newDirectory);
								son = "";
							} else {
								son = "";
							}
						}

						builder = new StringBuilder();
					} else {
						builder.append(filepaths.get(i).charAt(j));
					}
				}



			}
				else if(substring.equals("f:")) {
				int lastIndex;
				if (i == filepaths.size()-1) {
					lastIndex = filepaths.get(i).lastIndexOf(lastChar);
				} else {
					lastIndex = filepaths.get(i).lastIndexOf(' ');
					lastIndex--;
				}

				String son = "";
//				String parent = "";
				File newFile = null;


				int beginIndex = 1;
				StringBuilder builder = new StringBuilder();

				for (int j = lastIndex; j >= beginIndex; j--) {

					if (Character.compare(filepaths.get(i).charAt(j), '/') ==0 || Character.compare(filepaths.get(i).charAt(j), ':') ==0) {
						String backwardString = builder.toString();
						String normalString = reverseString(backwardString);

						if (!isCreated(nodes, normalString)) {
							if (son == "") {
								son = normalString;
								newFile =  new File(son,null);
								nodes.add(newFile);
							}
						}
						else {
							if (!son.equals("")) {
								Directory parentDirectory = (Directory) returnNode(nodes, normalString);
								newFile.parent = parentDirectory;
								parentDirectory.addNode(newFile);
								son = "";
							} else {
								son = "";
							}
						}


						builder = new StringBuilder(); // every time a create a new node i reset the builder
					} else {
						builder.append(filepaths.get(i).charAt(j));
					}
				}

			}
		}
	}



}
