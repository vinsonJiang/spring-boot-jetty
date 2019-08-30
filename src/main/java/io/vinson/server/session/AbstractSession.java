package io.vinson.server.session;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: jiangweixin
 * @date: 2019/8/23
 */
public class AbstractSession {
    public <T extends SessionManagerSkeleton.SessionSkeleton> AbstractSession(SessionManagerSkeleton skeleton, HttpServletRequest request) {

    }

    public <T extends SessionManagerSkeleton.SessionSkeleton> AbstractSession(SessionManagerSkeleton skeleton, long created, long accessed, String clusterId) {

    }

    protected void timeout() {

    }

    public void invalidate() {

    }
}
