package by.tms.action;

import by.tms.action.util.Reader;
import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.service.StudentService;

import java.util.List;

import static by.tms.action.util.Reader.readId;
import static by.tms.action.util.Reader.readWithInvite;
import static by.tms.action.util.Writer.writeln;

public class StudentAction {

	private StudentService studentService = new StudentService();

	public void addStudent () {
		Writer.write("Введите имя:");
		String name = Reader.readName();
		Writer.write("Введите логин:");
		String login = Reader.readLine();
		Writer.write("Введите пароль:");
		String password = Reader.readLine();
		Writer.write("Введите факультет:");
		String faculty = Reader.readLine();
		Writer.write("Введите группу:");
		String group = Reader.readLine();
		if (studentService.add (name, login, password, faculty, group)) {
			Writer.write("Студент " + login + " добавлен.");
		} else {
			Writer.write("Ошибка добавления, такой студент уже существует");
		}
	}

	public void changeStudentPasswordByLogin () {
		String login = readWithInvite("Input Login");
		String password = readWithInvite("Input password");
		if (studentService.changeStudentPasswordByLogin(login, password)) {
			writeln("Password changed");
		} else
			writeln("Error.");
	}


	public void removeStudent() {
		String login = readWithInvite("Input student Login: "),
		if(studentService.removeStudent(login))
			writeln("Student was successfully removed!");
		else
			writeln("Student with Login(" + login + ") not found OR password is incorrect!");
	}

	public void findAll() {
		writeln("-= List of ALL students =-");
		List<Student> students = studentService.getAllStudents();
		for (int i = 0; i < students.size(); i++ ) {
			writeln(students.get(i));
		}
	}

	public void findByLogin() {
		String login = readWithInvite("Input Login: ");
		Student student = studentService.searchStudentByLogin(login);
		if(student != null)
			writeln("Founded Student with login:" + login +" :\n" + student.toString());
		else
			writeln("Student with Login(" + login + ") not found!");
	}

	public void updateById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setName(readWithInvite("Input new Name: "));
			student.setFaculty(readWithInvite("Input new Faculty: "));
			student.setGroup(readWithInvite("Input new Group: "));
			if(studentService.updateStudent(student))
				writeln("Student successfully updated!");
		}
	}

	public void updateNameById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setName(readWithInvite("Input new Name: "));
			if(studentService.updateStudent(student))
				writeln("Student successfully updated!");
		}
	}

	public void updatePasswordById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			String newPassword = readWithInvite("Input NEW Paword: ");
			String confPassword = readWithInvite("Input NEW Paword again: ");
			if(newPassword.equals(confPassword))
				if(studentService.updateStudent(student))
					writeln("Password successfully changed!");
		}
	}

	public void updateFacultyById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setFaculty(readWithInvite("Input new Faculty: "));
			if(studentService.updateStudent(student))
				writeln("Student faculty successfully updated!");
		}
	}

	public void updateGroupById() {

		Student student = null;

		if(student = getStudentById(readId()) == null) {
			writeln("Student with such ID not found!");
			return;
		}

		if(student.checkPassword(readWithInvite("Input Password: "))) {
			student.setGroup(readWithInvite("Input new Group: "));
			if(studentService.updateStudent(student))
				writeln("Student group successfully updated!");
		}
    
	public void registration() {
		System.out.println("Enter name");
	}

	//


	public void remove() { // Вариант remove, где передается целый студент. Думаю, надо передавать только String
		Writer.write("Введите логин для удаления:");
		Student studentForRemove = new Student();
		String login = Reader.readLine();
		studentForRemove.setLogin(login);
		if (studentService.remove(studentForRemove)) {
			Writer.write("Студент " + login + " удален");
		}
	}

	public void remove2() {
		Writer.write("Введите логин для удаления:");
		String login = Reader.readLine();
		if (studentService.remove2(login)) {
			Writer.write("Студент " + login + " удален");
		} else {
			Writer.write("Таких студентов не найдено");
		}
	}

	public void findAll() {
		studentService.getAllStudents();
		Writer.write("Список студентов.");
	}

	public void searchByLogin() {
		Writer.write("Введите логин для поиска по логину:");
		String login = Reader.readLine();
		Student studentByLogin = studentService.searchByLogin(login);
		if (studentByLogin == null) {
			Writer.write("Студентов с таким логином не существует");
		} else {
			Writer.write("Студент " + login + " найден.");
			Writer.write(studentByLogin);
		}
	}

	public void updateById() { //  Я не понял, что должно обновляться по Id
		Writer.write("Введите ID для обновления");
		Long id = Reader.readLong();
	}

	public void updateNameById() {
		Writer.write("Введите Id для обновления имени:");
		Long id = Reader.readLong();
		Writer.write("Введите новое имя:");
		String name = Reader.readName();
		studentService.updateNameById(id, name);
	}

	public void updatePasswordById() {
		Writer.write("Введите Id для обновления пароля:");
		Long id = Reader.readLong();
		if (studentService.searchById(id)) {
			Writer.write("Введите новый пароль:");
			String newPassword = Reader.readLine();
			studentService.changePasswordById(id, newPassword);
		}
	}

	public void updateFacById() {
		Writer.write("Введите Id для обновления факультета:");
		Long id = Reader.readLong();
		if (studentService.searchById(id)) {
			Writer.write("Введите новый факультет:");
			String newFaculty = Reader.readLine();
			studentService.changeFaculty(id, newFaculty);
		}
	}

	public void updateGroupById() {
		Writer.write("Введите Id для обновления группы:");
		Long id = Reader.readLong();
		if (studentService.searchById(id)) {
			Writer.write("Введите новую группу:");
			String newGroup = Reader.readLine();
			studentService.changeGroup(id, newGroup);
		}
	}

}