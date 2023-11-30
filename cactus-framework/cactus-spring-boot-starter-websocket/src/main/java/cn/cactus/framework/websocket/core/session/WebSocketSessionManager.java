package cn.cactus.framework.websocket.core.session;

import org.springframework.web.socket.WebSocketSession;

import java.util.Collection;

/**
 * Package: cn.cactus.framework.websocket.core.session
 * Description:
 * {@link WebSocketSession} 管理器的接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:06
 * @Github https://github.com/lixuanfengs
 */
public interface WebSocketSessionManager {

    /**
     * 添加 Session
     *
     * @param session Session
     */
    void addSession(WebSocketSession session);

    /**
     * 移除 Session
     *
     * @param session Session
     */
    void removeSession(WebSocketSession session);

    /**
     * 获得指定编号的 Session
     *
     * @param id Session 编号
     * @return Session
     */
    WebSocketSession getSession(String id);

    /**
     * 获得指定用户类型的 Session 列表
     *
     * @param userType 用户类型
     * @return Session 列表
     */
    Collection<WebSocketSession> getSessionList(Integer userType);

    /**
     * 获得指定用户编号的 Session 列表
     *
     * @param userType 用户类型
     * @param userId 用户编号
     * @return Session 列表
     */
    Collection<WebSocketSession> getSessionList(Integer userType, Long userId);

}