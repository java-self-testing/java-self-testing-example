package cn.prinf.demos.junit.api.config;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.sql.SQLException;

@Service
public class ResetDbService {

    private static IDatabaseConnection connection;

    @Autowired
    private DataSource dataSource;
    private File tempFile;

    public void backup() throws Exception {
        this.getConnection();
        this.backupCustom();
    }

    public void rollback() throws Exception {
        this.reset();
        this.closeConnection();
    }

    protected void backupCustom() {
        try {
            QueryDataSet queryDataSet = new QueryDataSet(connection);
            queryDataSet.addTable("user");
            tempFile = new File("temp.xml");
            FlatXmlDataSet.write(queryDataSet, new FileWriter(tempFile), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getConnection() throws DatabaseUnitException {
        connection = new DatabaseConnection(DataSourceUtils.getConnection(dataSource));
    }

    protected void reset() throws FileNotFoundException, DatabaseUnitException, SQLException {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        builder.setColumnSensing(true);
        IDataSet dataSet = builder.build(new FileInputStream(tempFile));

        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }

    protected void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
