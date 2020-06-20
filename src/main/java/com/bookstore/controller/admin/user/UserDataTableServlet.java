//package com.bookstore.controller.admin.user;
//
//import com.bookstore.serviceimpl.utils.SingletonDaoUtil;
//import org.hibernate.HibernateException;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.*;
//
//@WebServlet(name = "UserDataTableServlet", urlPatterns = "/admin/datatable_users")
//public class UserDataTableServlet extends HttpServlet {
//    private String GLOBAL_SEARCH_TERM;
//    private String COLUMN_NAME;
//    private String DIRECTION;
//    private int INITIAL;
//    private int RECORD_SIZE;
//    private String INDEX_SEARCH_TERM,EMAIL_SEARCH_TERM,FULLNAME_SEARCH_TERM;
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String[] columnNames = { "index", "userId", "email", "fullname", "action"};
//
//        JSONObject jsonResult = new JSONObject();
//        int listDisplayAmount = 10;
//        int start = 0;
//        int column = 0;
//        String dir = "asc";
//        String pageNo = request.getParameter("iDisplayStart");
//        String pageSize = request.getParameter("iDisplayLength");
//        String colIndex = request.getParameter("iSortCol_0");
//        String sortDirection = request.getParameter("sSortDir_0");
//
//        if (pageNo != null) {
//            start = Integer.parseInt(pageNo);
//            if (start < 0) {
//                start = 0;
//            }
//        }
//        if (pageSize != null) {
//            listDisplayAmount = Integer.parseInt(pageSize);
//            if (listDisplayAmount < 10 || listDisplayAmount > 50) {
//                listDisplayAmount = 10;
//            }
//        }
//        if (colIndex != null) {
//            column = Integer.parseInt(colIndex);
//            if (column < 0 || column > 5)
//                column = 0;
//        }
//        if (sortDirection != null) {
//            if (!sortDirection.equals("asc"))
//                dir = "desc";
//        }
//
//        String colName = columnNames[column];
//        int totalRecords= -1;
//        try {
//            totalRecords = SingletonDaoUtil.getUserDaoInstance().getTotalRecordCount();
//        } catch (HibernateException e1) {
//            e1.printStackTrace();
//        }
//
//        RECORD_SIZE = listDisplayAmount;
//        GLOBAL_SEARCH_TERM = request.getParameter("sSearch");
//        INDEX_SEARCH_TERM=request.getParameter("sSearch_0");
//        EMAIL_SEARCH_TERM=request.getParameter("sSearch_1");
//        FULLNAME_SEARCH_TERM=request.getParameter("sSearch_2");
//        COLUMN_NAME = colName;
//        DIRECTION = dir;
//        INITIAL = start;
//
//        try {
//            jsonResult = getPersonDetails(totalRecords, request);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        response.setContentType("application/json");
//        response.setHeader("Cache-Control", "no-store");
//        PrintWriter out = response.getWriter();
//        out.print(jsonResult);
//    }
//
//    public JSONObject getPersonDetails(int totalRecords, HttpServletRequest request)
//            throws SQLException, ClassNotFoundException {
//
////            FROM SpeakerEntity WHERE 1=1  AND  LOWER(phone) LIKE '%' || :phone || '%'  AND  LOWER(fullName) LIKE '%'
////            || :fullName || '%'  AND  LOWER(email) LIKE '%' || :email || '%'  AND  LOWER(status) LIKE '%' || :status || '%'
//
//        int totalAfterSearch = totalRecords;
//        JSONObject result = new JSONObject();
//        JSONArray array = new JSONArray();
//        String searchSQL = "";
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        String dbConnectionURL = "jdbc:mysql://localhost:3306/faruk?user=root&password=root";
//        Connection con = DriverManager.getConnection(dbConnectionURL);
//        String sql = "SELECT " + "userId, email, fullName " + "FROM " + "users " + "WHERE ";
//
//        String globeSearch = "userId like '%" + GLOBAL_SEARCH_TERM + "%'"
//                + "or email like '%" + GLOBAL_SEARCH_TERM + "%'"
//                + "or fullName like '%" + GLOBAL_SEARCH_TERM + "%'";
//
//        String userIdSearch="userId like " + INDEX_SEARCH_TERM + "";
//        String emailSearch="email like '%" + EMAIL_SEARCH_TERM + "%'";
//        String fullNameSearch=" place like '%" + FULLNAME_SEARCH_TERM + "%'";
//        if (GLOBAL_SEARCH_TERM != "") {
//            searchSQL = globeSearch;
//        }
//        else if(INDEX_SEARCH_TERM !="")
//        {
//            searchSQL=userIdSearch;
//        }
//        else if(EMAIL_SEARCH_TERM !="")
//        {
//            searchSQL=emailSearch;
//        }
//        else if(FULLNAME_SEARCH_TERM!="")
//        {
//            searchSQL=fullNameSearch;
//        }
//
//        sql += searchSQL;
//        sql += " order by " + COLUMN_NAME + " " + DIRECTION;
//        sql += " limit " + INITIAL + ", " + RECORD_SIZE;
//        //for searching
//        PreparedStatement stmt = con.prepareStatement(sql);
//        ResultSet rs = stmt.executeQuery();
//
//        while (rs.next()) {
//            JSONArray ja = new JSONArray();
//            ja.put(rs.getString("id"));
//            ja.put(rs.getString("email"));
//            ja.put(rs.getString("fullName"));
//            array.put(ja);
//        }
//        stmt.close();
//        rs.close();
//
//        String query = "SELECT " + "COUNT(*) as count " + "FROM " + "users " + "WHERE ";
//
//        //for pagination
//        if (GLOBAL_SEARCH_TERM != ""||INDEX_SEARCH_TERM != "" || EMAIL_SEARCH_TERM != "" ||FULLNAME_SEARCH_TERM != "") {
//            query += searchSQL;
//
//            PreparedStatement st = con.prepareStatement(query);
//            ResultSet results = st.executeQuery();
//
//            if (results.next()) {
//                totalAfterSearch = results.getInt("count");
//            }
//            st.close();
//            results.close();
//            con.close();
//        }
//        try {
//            result.put("iTotalRecords", totalRecords);
//            result.put("iTotalDisplayRecords", totalAfterSearch);
//            result.put("aaData", array);
//        } catch (Exception e) {
//
//        }
//        return result;
//    }
//}
