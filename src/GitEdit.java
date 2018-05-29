import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class GitEdit {

	public static void main(String[] args) {

		String inputPath = "C:\\workspace\\filestoedit.txt";
		// find c:/workspace/ -name '.gitignore' > c:/workspace/filestoedit.txt

		String[] pathListToEdit = generatePathListToEdit(inputPath);

		for (int i = 0; i < pathListToEdit.length; i++) {
			editFile(pathListToEdit[i]);
		}

	}

	private static void editFile(String pathToEditFiles) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(pathToEditFiles, true);
			fileWriter.write(System.lineSeparator() + ".settings");
			//fileWriter.write(System.lineSeparator() + ".classpath");
			fileWriter.close();

		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}

	private static String[] generatePathListToEdit(String inputPath) {
		ArrayList<String> listFileToEdit = new ArrayList<String>();
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(inputPath));
			String read = "";

			while ((read = fileReader.readLine()) != null) {
				listFileToEdit.add(read);
			}

		} catch (java.io.IOException e) {
			System.out.println(e);
		}

		String[] listModifiedFilePath = new String[listFileToEdit.size()];
		for (int i = 0; i < listFileToEdit.size(); i++) {
			String modifiedFilePath = "";
			for (int j = 0; j < listFileToEdit.get(i).length(); j++) {

				if (listFileToEdit.get(i).charAt(j) == '/') {
					modifiedFilePath = modifiedFilePath + "\\" + "\\";
				} else {
					modifiedFilePath = modifiedFilePath + listFileToEdit.get(i).charAt(j);
				}
				listModifiedFilePath[i] = modifiedFilePath;
			}
		}
		return listModifiedFilePath;
	}
}