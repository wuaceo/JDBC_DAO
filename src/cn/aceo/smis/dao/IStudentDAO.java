package cn.aceo.smis.dao;

import java.util.List;
import cn.aceo.smis.domain.Student;

public interface IStudentDAO {
	/**
	 * �������
	 * @param stu Ҫ�����ѧ��������Ϣ
	 */
	void save(Student stu);
	/**
	 * ɾ������
	 * @param id Ҫɾ����ѧ����Ϣ������ֵ
	 */
	void delete(Long id);
	/**
	 * ���²���
	 * @param id Ҫ���µ�ѧ����Ϣ������ֵ
	 * @param newStu �µ�ѧ����Ϣ
	 */
	void update(Long id,Student newStu);
	/**
	 * ����ID��ѯһ��ѧ����Ϣ
	 * @param id Ҫ��ѯ��ѧ����Ϣ������ֵ
	 * @return ���id���ھͷ��ظ�ѧ������Ϣ����������ھͷ���Ϊnull
	 */
	Student get(Long id);
	/**
	 * ��ѯ���е�ѧ����Ϣ
	 * @return ��������Ϊ�վͷ���һ���յ�list����
	 */
	List<Student> listAll();
}
