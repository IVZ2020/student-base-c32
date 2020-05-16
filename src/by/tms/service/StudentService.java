package by.tms.service;

import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.storage.StudentStorage;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
	private StudentStorage studentStorage = new StudentStorage();

	public boolean add (String name, String login, String password, String faculty, String group) {
		if (!studentStorage.checkByLogin(login)) {
			studentStorage.saveStudent(name, login, password, faculty, group);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeStudentByLogin (String login) {
		if (studentStorage.checkByLogin(login)) {
			long id = studentStorage.returnIdByLogin(login);
			studentStorage.removeStudentById(id);
			return true;
		} else {
			return false;
		}
	}

	public Student searchStudentByLogin(String login) {
		if (studentStorage.checkByLogin(login)) {
			return studentStorage.getStudentByLogin(login);
		} else
		return null;
	}

	public boolean changeStudentPasswordByLogin(String login, String newPassword) {
		if (studentStorage.checkByLogin(login)) {
			studentStorage.updatePasswordByLogin(login, newPassword);
			return true;
		}
		return false;
	}

	public boolean changePasswordById(Long id, String newPassword) {
		if (studentStorage.checkById(id)) {
			studentStorage.updatePasswordById(id, newPassword);
			return true;
		}
		return false;
	}

	public boolean updateNameFacultyGroupById (long id, String password, String newName, String newFaculty, String newGroup) {
		if (studentStorage.updateNameFacultyGroupById(id, password,newName, newFaculty, newGroup)) {
		return true;
		}
		return false;
	}

	public ArrayList<Student> getStudentGroupList(String group) {
		if (studentStorage.checkByGroup(group)) {
			return studentStorage.getStudentGroup(group);
		}
		return null;
	}

	public ArrayList<Student> getStudentFacultyList(String faculty) {
		if (studentStorage.checkByFaculty(faculty)) {
			return studentStorage.getStudentFaculty(faculty);
		}
		return null;
	}

//	public boolean changeFaculty(Student student, String faculty) {
//		if (studentStorage.existFaculty(student.getFaculty())) {
//			studentStorage.changeFaculty;
//			return true;
//		}
//		else{
//			Writer.write("Такого факультета не существует");
//		}
//		return false;
//	}

	public boolean changeFaculty(Long id, String newFaculty) {
		if (studentStorage.checkById(id)) {
			studentStorage.updateFacultyById(id, newFaculty);
			return true;
		}
		else{
			Writer.write("Такого факультета не существует");
		}
		return false;
	}

	public boolean changeGroup(Long id, String newGroup) {
		if (studentStorage.checkById(id)) {
			studentStorage.updateGroupById(id, newGroup);
			return true;
		}
		else{
			Writer.write("Такого факультета не существует");
		}
		return false;
	}

	public List<Student> getAllStudents() { // Написать метод для вывода списка всех студентов
		return studentStorage.getAllStudents();
	}

	public boolean searchById (Long id) {
		if (studentStorage.checkById(id)) {
			return true;
		}
		return false;
	}

	public boolean searchByLogin (String login) {
		if (studentStorage.checkByLogin(login)) {
			return true;
		}
		return false;
	}

	public void updateNameById(Long id, String name) {
		if (studentStorage.checkById(id)) {
			studentStorage.updateNameById(id, name);
		}
	}

	public boolean updateFacultyById (long id, String newFaculty) {
		if (studentStorage.checkById(id)) {
		studentStorage.updateFacultyById(id, newFaculty);
		return true;
		}
		return false;
	}

	public boolean updateGroupById (long id, String newGroup) {
		if (studentStorage.checkById(id)) {
			studentStorage.updateGroupById(id, newGroup);
			return true;
		}
		return false;
	}






} // end of StudentService
