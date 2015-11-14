package pe.gob.mintra.scv.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mintra.scv.dao.CursoDao;
import pe.gob.mintra.scv.model.Curso;

@Repository("cursoDaoImpl")
public class CursoDaoImpl implements CursoDao{
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;	
	

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Curso> listarCursos() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Curso> lstCurso = new ArrayList<Curso>();
		try {
			CursoDao cursoDao = session
					.getMapper(CursoDao.class);
			lstCurso = cursoDao.listarCursos();
		} catch (Exception ex) {		
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}
		return lstCurso;
		
		
	}

	@Override
	public Curso obtenerCurso(Curso objCurso) {
		SqlSession session = sqlSessionFactory.openSession();
		Curso curso = null;
		try {
			CursoDao cursoDao = session
					.getMapper(CursoDao.class);
			curso = cursoDao.obtenerCurso(objCurso);
		} catch (Exception ex) {		
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}
		return curso;
	}

	@Override
	public void grabarCurso(Curso objCurso) {
		// TODO Auto-generated method stub
		
	}

	//@Transactional
	public void actualizarCurso(Curso objCurso) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			CursoDao cursoDao = session.getMapper(CursoDao.class);
			cursoDao.actualizarCurso(objCurso);
			session.commit();
		} catch (Exception ex) {
			session.rollback();			
			System.out.println(ex.getMessage());
		} finally {
			session.close();
		}

		
	}

	@Override
	public void eliminarCurso(Curso objCurso) {
		// TODO Auto-generated method stub
		
	}
	
	

}
