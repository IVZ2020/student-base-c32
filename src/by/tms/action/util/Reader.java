package by.tms.action.util;

import java.util.Scanner;

public class Reader {

<<<<<<<<< Temporary merge branch 1

    public static double readDouble() {
        while (true) {
            try {
                double number = Double.parseDouble(readWithInvite("Enter data"));
                if (number < 0) throw new NullPointerException();
                return number;
            } catch (NullPointerException | NumberFormatException e) {
                Writer.write("Id incorrect! Try again!");
            }
        }
    }


    public static String readName() {
        Scanner scanner = new Scanner(System.in);
        String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
        String name = scanner.nextLine();
        String[] str = name.split("");
        for (String s : str)
            if (specialCharacters.contains(s)) {
                Writer.write("String contains special characters or string is empty,try again!");
                return null;
            }
        return name;
    }

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            Writer.write("Was entered empty string,try again!");
            return null;
        }
        return line;
    }


    public static String readWithInvite(String invite) {
        Writer.write(invite);
        return readLine();
    }

    public static long readId() {
        while (true) {
            try {
                long id = Long.parseLong(readWithInvite("Input Student ID: "));
                if (id < 0) throw new NumberFormatException();
                return id;
            } catch (NumberFormatException e) {
                Writer.write("Id incorrect! Try again!");
            }
        }
    }

    public static int readMenuChoice() {
        while (true) {
            try {
                int input = Integer.parseInt(readLine());
                if (input < 0) throw new NumberFormatException();
                return input;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }


=========
	public static double readDouble() {
		while (true) {
			try {
				double number = Double.parseDouble(readWithInvite("Enter data"));
				if (number < 0) throw new NullPointerException();
				return number;
			} catch (NullPointerException | NumberFormatException e) {
				Writer.write("Id incorrect! Try again!");
			}
		}
	}


	public static String readName() {
		Scanner scanner = new Scanner(System.in);
		String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
		String name = scanner.nextLine();
		String[] str = name.split("");
		for (String s : str)
			if (specialCharacters.contains(s)) {
				Writer.write("String contains special characters or string is empty,try again!");
				return null;
			}
		return name;
	}

	public static String readLine() {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		if (line.isEmpty()) {
			Writer.write("Was entered empty string,try again!");
			return null;
		}
		return line;
	}


	public static String readWithInvite(String invite) {
		Writer.write(invite);
		return readLine();
	}

	public static long readId() {
		while (true) {
			try {
				long id = Long.parseLong(readWithInvite("Input Student ID: "));
				if (id < 0) throw new NumberFormatException();
				return id;
			} catch (NumberFormatException e) {
				Writer.write("Id incorrect! Try again!");
			}
		}
	}
>>>>>>>>> Temporary merge branch 2
}
