﻿package Controller;

import Dao.User;
import Dao.UserInfo;
import DataBase.DataService;
import DataBase.DataServiceimpl;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;



public class Messages extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
        if ("loginRoom".equals(action)) {	//登录时，写入系统公告
            this.loginRoom(request, response);
        } else if ("sendMessage".equals(action)) {	//发送聊天信息
            this.sendMessages(request, response);
        } else if ("getMessages".equals(action)) {		//从XML文件中读取聊天信息
            this.getMessages(request, response);
        } else if("leaveRoom".equals(action)){
        	this.leaveRoom(request, response);
        }
    }
    
    
    private void leaveRoom(HttpServletRequest request,
			HttpServletResponse response) {
    	response.setContentType("text/html;charset=UTF-8");
    	ServletContext application=getServletContext();
    	HttpSession session = request.getSession();
    	String username = (String)session.getAttribute("username");
    	UserInfo user=UserInfo.getInstance();		//获得UserInfo类的对象
		Vector vector=user.getList();
    	String sourceMessage="";
    	if(null!=application.getAttribute("message")){
    		sourceMessage=application.getAttribute("message").toString();
    	}
    	sourceMessage+="系统公告：<font color='gray'>" + username + "退出聊天室！</font><br>";
    	application.setAttribute("message",sourceMessage);
    	if(vector!=null&&vector.size()>0&&username!=null){
			for(int i=0;i<vector.size();i++){
				if(username.equals(vector.elementAt(i))){
					vector.remove(i);
					break;
				}
			}
		}
    	session.invalidate();
    	try {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	} catch (Exception ex) {
    		Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
    	}
	}
    
    	// 将页面重定向到显示聊天信息的页面
	public void getMessages(HttpServletRequest request,HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {

            request.getRequestDispatcher("content.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
        }

	}

	// 登录时，写入系统公告

	public void loginRoom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		DataService service = new DataServiceimpl();
		session.setMaxInactiveInterval(3600);		//设置Session的过期时间为10分钟
		
		//保存用户信息
		session.setAttribute("username",username);	//保存当前登录的用户名
		session.setAttribute("loginTime",new Date().toLocaleString());		//保存登录时间
        ServletContext application=getServletContext();

        String sourceMessage="";

        if(null!=application.getAttribute("message")){
            sourceMessage=application.getAttribute("message").toString();
        }
        sourceMessage+="系统公告：<font color='gray'>" + username + "进入聊天室！</font><br>";
        application.setAttribute("message",sourceMessage);
        try {
            request.getRequestDispatcher("login_ok.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
        }
		}

	// 发送聊天信息
    public void sendMessages(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            Random random = new Random();
            String from = request.getParameter("from"); //发言人
            String face = request.getParameter("face"); //表情
            String to = request.getParameter("to"); //接收者
            String color = request.getParameter("color"); //字体颜色
            String content = request.getParameter("content"); //发言内容
            String sendTime = new Date().toLocaleString(); //发言时间
            ServletContext application = getServletContext();
            String sourceMessage = application.getAttribute("message").toString();
            try {
                //发言时间
                sourceMessage += "<font color='blue'><strong>" + from + "</strong></font><font color='#CC0000'>" + face + "</font>对<font color='green'>[" + to + "]</font>说：" + "<font color='" + color + "'>" + content + "</font>（" + sendTime + "）<br>";
                application.setAttribute("message", sourceMessage);
                request.getRequestDispatcher("Messages?action=getMessages&nocache=" + random.nextInt(10000)).forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(Messages.class.getName()).log(Level.SEVERE, null, ex);
            }

	}


// <editor-fold defaultstate="collapsed" desc="HttpServlet 方法。单击左侧的 + 号以编辑代码。">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}