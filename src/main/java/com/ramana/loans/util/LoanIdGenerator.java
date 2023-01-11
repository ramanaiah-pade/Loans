package com.ramana.loans.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoanIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Long prefix = 10000000L;
       try ( Connection connection = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection()){
           Statement statement=connection.createStatement();
           ResultSet rs=statement.executeQuery("select count(loan_number) as accNo from loans");
           if(rs.next())
           {
               Long id=rs.getLong(1) + 1;
               Long generatedId = prefix + new Long(id);
               return generatedId;
           }
       }catch (Exception e){
            throw new RuntimeException("Exception Occurred in AccountNumberGenerator class : \n" + e.getMessage());
       }
       return null;
    }
}
