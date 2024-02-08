package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.AddressEntity;
import pojos.StudentEntity;

public class IAddressDAOImpl implements IAddressDAO {

	@Override
	public String assignAddressDetails(int studentId, AddressEntity address) {
		String mesg = "linking address failed... ";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			StudentEntity s = session.get(StudentEntity.class, studentId);
			if(s != null) {
				address.setStudent(s);//established uni-directional association from Address ---> Student
				session.persist(address);
				mesg = "Linking Address Success";
			}
			tx.commit();
		}catch(RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
