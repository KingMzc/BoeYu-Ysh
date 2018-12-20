package com.BoeYu.controller;


import com.BoeYu.pojo.RealTimeCoordinates;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocket/{uid}")
public class WebSocket {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();
    private static Map<String, WebSocket> map = new HashMap<String, WebSocket>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("uid")String uid){
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        map.put(uid,this);
       // System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        //System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }
    /**
     * 收到客户端消息后调用的方法
     * @param data 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String data,@PathParam("uid")String uid) throws IOException {
        if(data.contains("Coordinate")){
            String[] qq = data.split(":");
            /*String[] ww = qq[1].split("-");*/
            RealTimeCoordinates.setmap(uid,qq[1]);
        }else{
            //群发消息
            Set<String> set = map.keySet(); //取出所有的key值
            String[] ss = data.split("-");
            int send=0;
            for (String key:set) {
                if(ss[0].equals(key)){
                    send++;
                }
            }
            if(send>0){
                map.get(ss[0]).sendMessage(ss[1]);
            }else{
                //map.get(uid).sendMessage("对方没有在线，发送失败！");
            }
        }
    }
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("websocket"+ new Date());
        //error.printStackTrace();
    }
    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public static int sendmsg(String id,String message) throws IOException {
        int flag = 0;
        if(map.get(id)!=null){
            if(map.get(id).session.isOpen()==true){
                map.get(id).sendMessage(message);
                flag++;
            }
        }
        return flag;
    }

    public  void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }
    public void send(String list) throws IOException{

        this.session.getBasicRemote().sendText(list);
        //this.session.getAsyncRemote().sendText(message);
    }
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }
    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }
    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}