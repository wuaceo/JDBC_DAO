package cn.aceo.smis.test;

import java.util.List;
import org.junit.Test;
import cn.aceo.smis.dao.IStudentDAO;
import cn.aceo.smis.dao.impl.StudentDAOImpl;
import cn.aceo.smis.domain.Student;

public class StudentDAOTest {
	IStudentDAO studentDAO=new StudentDAOImpl();
	@Test
	public void testSave() {
		Student stu=new Student();
		stu.setName("ÎâÀÏÌ«");
		stu.setAge(198);
		studentDAO.save(stu);
	}

	@Test
	public void testDelete() {
		studentDAO.delete(4L);
	}

	@Test
	public void testUpdate() {
		Student newStu=new Student();
		newStu.setName("ÎâÒå·¼");
		newStu.setAge(16);
		studentDAO.update(7L, newStu);
	}

	@Test
	public void testGet() {
		System.out.println(studentDAO.get(2L));		
	}

	@Test
	public void testListAll() {
		List<Student> list=studentDAO.listAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

}
