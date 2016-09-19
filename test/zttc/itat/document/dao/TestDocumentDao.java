package zttc.itat.document.dao;

import static org.junit.Assert.*;

import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import zttc.itat.document.model.Document;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
				  {
				   "classpath*:beans.xml",
				  }
				)
public class TestDocumentDao {
	@Inject
	private SessionFactory sessionFactory;

    Document baseDocument;
    Map<String,Object> searchCondition ;

	private IDocumentDao documentDao;
	
	public IDocumentDao getDocumentDao() {
		return documentDao;
	}

	// inject the documentDao in the setter method
	@Resource
	public void setDocumentDao(IDocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@Before
	public void setUp() {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
	    documentDao = new DocumentDao();
	}

	@Test
	public void test_load_by_name() {

        Document document = documentDao.loadByName("doc3");
        Document baseDocument = new Document(2, -5, "doc3", "-5", "han", "2014-06-03", "1");
        assert_document_equals(document, baseDocument);
	}

	@Test
	public void testAdd() {
	    baseDocument = new Document(0, 0, "creater", "type", "creater", "createTime", "path");
        Document tDocument =baseDocument;
        System.out.print(tDocument.getCreater()+tDocument.getCreateTime()+tDocument.getName());
        assertNotNull(tDocument);
        assertNotNull(documentDao);
        System.out.print(documentDao.toString());

        documentDao.add(tDocument);	
        Document document = documentDao.loadByName("doc3");
        assertNotNull(document);
        assert_document_equals(document,baseDocument); 
      
	}

	@Test
	/*
	 * test the result given by the search method is the same as the base result 
	 */
	public void test_search_by_name() {

		

	}

	@After
	public void tearDown() {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		
	}
	
	private void assert_document_equals(Document document, Document baseDocument ) {
		
		assertEquals(document.getCreater(),baseDocument.getCreater());
        assertEquals(document.getCreateTime(),baseDocument.getCreateTime());
        assertEquals(document.getId(),baseDocument.getId());
        assertEquals(document.getPath(),baseDocument.getPath());
        assertEquals(document.getPid(),baseDocument.getPid());
        assertEquals(document.getType(), baseDocument.getType());
	}
}
