/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdegroupexercise.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sdegroupexercise.BLL.BLLManager;

/**
 *
 * @author sebok
 */
public class DALManager implements DataAccesInterface
{

    ConnectionManager cm = new ConnectionManager();
    static BLLManager BLLM = new BLLManager();

    @Override
    public String getDataFromDB() throws DALException
    {
        try(Connection con = cm.getConnection();)
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Jokes WHERE ID = " + BLLM.getRandom());
            rs.next();
            return rs.getString("joke");
        }
        catch (SQLException ex)
        {
            throw new DALException(ex);
        }
    }
    
}
