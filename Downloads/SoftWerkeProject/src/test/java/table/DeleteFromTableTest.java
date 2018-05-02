package table;

import com.nikolay.imbirev.model.entities.Query;
import com.nikolay.imbirev.model.dao.AbstractDao;
import com.nikolay.imbirev.model.exceptions.DatabaseAccessException;
import com.nikolay.imbirev.model.executors.AbstractExecutor;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteFromTableTest {

    private AbstractExecutor executor;
    private AbstractDao dao;
    private final static Logger log = Logger.getLogger(DeleteFromTableTest.class);

    @Before
    public void setUp() {
        try {
            executor = new AbstractExecutor();
        } catch (DatabaseAccessException e) {
            log.error(e.getMessage());
        }
        dao = new AbstractDao(executor);
    }

    @Test
    public void test1() {
        int result = dao.deleteFromTable("Question_table", null).getValue();
        Assert.assertEquals(20, result);
        log.info("test 1 passed");
    }
    @Test
    public void test2() {
        int result = dao.deleteFromTable(null, new Query[]{}).getValue();
        Assert.assertEquals(20, result);
        log.info("test 2 passed");
    }
    @Test
    public void test3() {
        int result = dao.deleteFromTable("", new Query[]{}).getValue();
        Assert.assertEquals(20, result);
        log.info("test 3 passed");
    }
    @Test
    public void test4() {
        int result = dao.deleteFromTable("Question_table", new Query[]{
                new Query("lala", "baba")
        }).getValue();
        Assert.assertEquals(99, result);
        log.info("test 4 passed");
    }
    @Test
    public void test5() {
        int result = dao.deleteFromTable("table", new Query[]{}).getValue();
        Assert.assertEquals(99, result);
        log.info("test 5 passed");
    }
    @Test
    public void test6() {
        int result = dao.deleteFromTable("no table existing", new Query[]{}).getValue();
        Assert.assertEquals(99, result);
        log.info("test 6 passed");
    }
    @Test
    public void test7() {
        int result = dao.deleteFromTable("Question_table", new Query[]{
                new Query("text", "koko")
        }).getValue();
        Assert.assertEquals(0, result);
        log.info("test 7 passed");
    }





}