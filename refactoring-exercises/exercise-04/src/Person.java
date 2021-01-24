public class Person {
	public String last;

	public String first;

	public String middle;

	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}

	public static void printPerson(Writer out, Person person) throws IOException {
		out.write(person.first);
		out.write(" ");
		if (person.middle != null) {
			out.write(person.middle);
			out.write(" ");
		}
		out.write(person.last);
	}

	public static String formatPerson(Person person) {
		String result = person.last + ", " + person.first;
		if (person.middle != null)
			result += " " + person.middle;
		return result;
	}

	public static void display(Writer out, Person person) throws IOException {
		out.write(person.last);
		out.write(", ");
		out.write(person.first);
		if (person.middle != null) {
			out.write(" ");
			out.write(person.middle);
		}
	}

	public static String toString(Person person) {
		return person.last + ", " + person.first
				+ ((person.middle == null) ? "" : " " + person.middle);
	}
}