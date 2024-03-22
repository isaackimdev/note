<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@page session="false"%>
<%@page import="java.net.*,java.io.*"%>
<%
    try {
        /** 접속할 OpenAPI의 URL */
        String reqUrl = request.getParameter("url");

        URL url = new URL(reqUrl);
        HttpURLConnection con = (HttpURLConnection) url
                .openConnection();
        con.setDoOutput(true);
        con.setRequestMethod(request.getMethod());
        int clength = request.getContentLength();
        if (clength > 0) {
            con.setDoInput(true);
            byte[] idata = new byte[clength];
            request.getInputStream().read(idata, 0, clength);
            con.getOutputStream().write(idata, 0, clength);
        }
        response.setContentType(con.getContentType());

        BufferedReader rd = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String line = null;
        while ((line = rd.readLine()) != null) {
            out.println(line);
        }
        rd.close();

    } catch (Exception e) {
        response.setStatus(500);
    }
%>