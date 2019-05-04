package com.yyh.job.config.webSocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package com.yyh.job.config.webSocket
 * @author: 昊天
 * @date: 2019-04-30 19:53
 * @since V1.1.0-SNAPSHOT
 */
@Component
@ServerEndpoint(value = "/webSocket/{id}")
@Slf4j
public class WebSocketServer {

    /**
     *     静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     * 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
     */
    public static final CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    private Integer id;

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen( @PathParam("id")Integer id, Session session){
        this.session = session;
        this.id = id;
        webSocketSet.add(this);
        addOnlineCount();
        log.info("用户:{}加入！当前在线人数为{}" ,id, getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        log.info("用户:{},关闭！当前在线人数为{}" ,getId(), getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("来自客户端的消息:" + message);
        //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param error
     */
    @OnError
    public void onError(Throwable error) {
        log.error("webSocket发生错误:",error.getMessage());
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        //同步阻塞
        this.session.getBasicRemote().sendText(message);
        log.info("给用户{}推送了消息：{}",id,message);
        //异步
        //this.session.getAsyncRemote().sendText(message);
    }

    /**
     * 群发消息
     * @param message
     */
    public void sendToAll(String message){
        for (WebSocketServer webSocketServer : webSocketSet){
            try {
                webSocketServer.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getOnlineCount() {
        return atomicInteger.get();
    }

    public static void addOnlineCount() {
        atomicInteger.incrementAndGet();
    }

    public static void subOnlineCount() {
        atomicInteger.decrementAndGet();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
