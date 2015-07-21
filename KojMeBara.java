  public class KojMeBara {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		CBHT<Integer, String> tabela = new CBHT<Integer, String>(2 * N);

		int broj;
		// ja polnime tabelata
		for (int i = 0; i < N; i++) {
			String red = br.readLine();
			String[] parts = red.split(" ");
			broj = Integer.parseInt(parts[0]);
			tabela.insert(broj, parts[1]);
		}

		String toCheck = br.readLine(); // vnesuvame informacii za broj na korisnik
		String first4digits = toCheck.substring(0, 4); // gi zemame prvite 4 cifri

		String number = "0";
		boolean flag = true;
		// ako prvite 4 cifri se +389
		if (first4digits.equals("+389")) {
			// gi zemame i poslednite 8 od brojot
			String last8digits = toCheck.substring(4, 12);
			// i na stringo mu gi davame tie
			number += last8digits;
		} // inaku ako e podolg od 9 cifri avtomatski ne e validen i printame nepoznat broj
		else if (toCheck.length() == 9) {
			number = toCheck; // ako e tocno na stringo mu gi davame tie
		} else {
			System.out.println("Nepoznat broj");
			flag = false; // flag go stavame na false bidejki veke nemame potreba od proverka
		}
		// ako e flag == true go barame brojot vo tabelata i ako go najdeme go printame t.e. printame value
		if (flag) {
			int numberToCheck = Integer.parseInt(number);
			String nameToPrint;
			SLLNode<MapEntry<Integer, String>> map = tabela
					.search(numberToCheck);

			if (map != null) {
				nameToPrint = map.element.value;
				System.out.println(nameToPrint);
			} else
				System.out.println("Nepoznat broj");
		}

	}

}
