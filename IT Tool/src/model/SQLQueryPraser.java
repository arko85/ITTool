package model;

public class SQLQueryPraser {


public String genQuery(  String towar, String ilosczam, String pO, String iloscodeb, String mpk, String odbiorca, Boolean com
		){

			StringBuffer query= new StringBuffer();
			query.append(" WHERE");


			if(!towar.isEmpty())query.append(" towar='"+towar+"' AND");
			if(!ilosczam.isEmpty())query.append(" ilosczam='"+ilosczam+"' AND");
			if(!pO.isEmpty())query.append(" pO LIKE'"+pO+"' AND");
			if(!iloscodeb.isEmpty())query.append(" ILOSCODEB="+ Integer.parseInt(iloscodeb)+" AND");
			if(!mpk.isEmpty())query.append(" mpk='"+mpk+"' AND");
			if(!odbiorca.isEmpty())query.append(" odbiorca='"+odbiorca+"' AND");
			if(!com)query.append(" STATUS !='"  +"COMPLETED"+ "' AND");

			if (query.length()>6)
								{query.delete(query.length()-3, query.length());
								return query.toString();
								} else
								{return "";}


}

}
