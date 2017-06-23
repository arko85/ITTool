package model;

import java.time.LocalDate;

public class SQLQueryPraser {


public String genQuery(  String towar, String ilosczam, String pO, String iloscodeb, String mpk, String odbiorca
		){

			StringBuffer query= new StringBuffer();
			query.append("SELECT * from Orders WHERE ");


			if(!towar.isEmpty())query.append("towar='"+towar+"' ");
			if(!ilosczam.isEmpty())query.append("ilosczam='"+ilosczam+"' ");
			if(!pO.isEmpty())query.append("pO='"+pO+"',");
			if(!iloscodeb.isEmpty())query.append("iloscodeb='"+iloscodeb+"' ");
			if(!mpk.isEmpty())query.append("mpk='"+mpk+"' ");
			if(!odbiorca.isEmpty())query.append("odbiorca='"+odbiorca+"'");
			query.append(";");

			return query.toString();

}

}
