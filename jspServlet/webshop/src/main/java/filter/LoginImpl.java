package filter;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

///**
// * Application Lifecycle Listener implementation class LoginImpl
// *
// */
//@WebListener
//public class LoginImpl implements HttpSessionBindingListener {
//
//   String user_id;
//   String user_pw;
//   static int total_user = 0;
//   
//    public LoginImpl(String user_id, String user_pw) {
//        this.user_id = user_id;
//        this.user_pw = user_pw;
//    }
//
//    public void valueBound(HttpSessionBindingEvent event)  { 
//         System.out.println("사용자 접속!!!!");
//         total_user++;
//    }
//
//    public void valueUnbound(HttpSessionBindingEvent event)  { 
//    	System.out.println("사용자 접속해제!!!!");
//        total_user--;
//    }
//	
//}
